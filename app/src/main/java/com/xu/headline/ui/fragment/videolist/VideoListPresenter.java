package com.xu.headline.ui.fragment.videolist;

import android.util.Base64;
import android.util.Log;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.response.TouTiaoNewsVideoItemBean;
import com.xu.headline.bean.response.TouTiaoNewsVideoListBean;
import com.xu.headline.bean.response.VideoAddressBean;
import com.xu.headline.net.HttpConstants;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.SharedPreUtil;
import com.xu.headline.utils.TransformUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;

import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/18.
 *
 * @author xu
 */

public class VideoListPresenter extends BasePresenter<IVideoListContract.IVideoListView> implements IVideoListContract.IVideoListPresenter {
    private final String URL_VIDEO = "/video/urls/v/1/toutiao/mp4/%s?r=%s";
    private final String HOST_VIDEO = "http://i.snssdk.com";
    /**
     * 获取视频地址的正则表达式
     */
    private static Pattern pattern = Pattern.compile("videoid:\'(.+)\'");

    @Override
    public void getVideoList(final String channelId, String refreshMode) {
        //最后一次刷新时间
        long lastRefreshTime = SharedPreUtil.getLong(channelId, System.currentTimeMillis() / 1000);
        RetrofitFactory.getTouTiaoApi()
                .getVideoList(channelId, lastRefreshTime, refreshMode)
                .map(new Function<TouTiaoNewsVideoListBean, List<TouTiaoNewsVideoItemBean>>() {
                    @Override
                    public List<TouTiaoNewsVideoItemBean> apply(TouTiaoNewsVideoListBean touTiaoNewsVideoListBean) throws Exception {
                        if (HttpConstants.REQUEST_SUCCESS.equals(touTiaoNewsVideoListBean.getMessage())) {
                            List<TouTiaoNewsVideoListBean.DataBean> dataBeanList = touTiaoNewsVideoListBean.getData();
                            List<TouTiaoNewsVideoItemBean> itemBeans = new ArrayList<>(dataBeanList.size());
                            for (TouTiaoNewsVideoListBean.DataBean dataBean : dataBeanList) {
                                String content = dataBean.getContent().replace("\\", "").replace("\"{", "{").replace("}\"", "}");
                                Logger.d(content);
                                TouTiaoNewsVideoItemBean itemBean = new Gson().fromJson(content, TouTiaoNewsVideoItemBean.class);
                                itemBeans.add(itemBean);
                            }
                            return itemBeans;
                        }
                        return null;
                    }
                })
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<List<TouTiaoNewsVideoItemBean>>() {
                    @Override
                    public void accept(List<TouTiaoNewsVideoItemBean> touTiaoNewsVideoItemBeans) throws Exception {
                        //入库
                    }
                })
                .compose(TransformUtils.<List<TouTiaoNewsVideoItemBean>>defaultSchedulers())
                .compose(mView.<List<TouTiaoNewsVideoItemBean>>bindToLife())
                .subscribe(new Consumer<List<TouTiaoNewsVideoItemBean>>() {
                    @Override
                    public void accept(List<TouTiaoNewsVideoItemBean> touTiaoNewsVideoItemBeans) throws Exception {
                        mView.loadVideoList(touTiaoNewsVideoItemBeans);
                        SharedPreUtil.putLong(channelId, System.currentTimeMillis() / 1000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.d(throwable.getMessage());
                    }
                });
    }

    @Override
    public void getVideoFrDB(String channel) {

    }

    @Override
    public void getVideoAddress(String url, final int position) {
        RetrofitFactory.getTouTiaoApi()
                .getVideoHtml(url)
                .flatMap(new Function<String, ObservableSource<VideoAddressBean>>() {
                    @Override
                    public ObservableSource<VideoAddressBean> apply(String response) throws Exception {
                        Matcher matcher = pattern.matcher(response);
                        if (matcher.find()) {
                            String videoId = matcher.group(1);
                            //1.将/video/urls/v/1/toutiao/mp4/{videoid}?r={Math.random()}，进行crc32加密。
                            Random random = new Random();
                            StringBuilder result = new StringBuilder();
                            for (int i = 0; i < 16; i++) {
                                result.append(random.nextInt(10));
                            }
                            String r = result.toString();
                            Logger.d(r);
                            CRC32 crc32 = new CRC32();
                            String s = String.format(URL_VIDEO, videoId, r);
                            //进行crc32加密。
                            crc32.update(s.getBytes());
                            String crcString = crc32.getValue() + "";
                            Log.d("crcString", crcString);
                            //2.访问http://i.snssdk.com/video/urls/v/1/toutiao/mp4/{videoid}?r={Math.random()}&s={crc32值}
                            String url = HOST_VIDEO + s + "&s=" + crcString;
                            Logger.d(url);
                            return RetrofitFactory.getTouTiaoApi().getVideoAddress(url);
                        }
                        return null;
                    }
                })
                .map(new Function<VideoAddressBean, VideoAddressBean.DataBean.VideoListBean.VideoBean>() {
                    @Override
                    public VideoAddressBean.DataBean.VideoListBean.VideoBean apply(VideoAddressBean videoAddressBean) throws Exception {
                        Logger.d("1");
                        if (videoAddressBean != null && HttpConstants.REQUEST_SUCCESS.equals(videoAddressBean.getMessage())) {
                            VideoAddressBean.DataBean.VideoListBean listBean = videoAddressBean.getData().getVideo_list();
                            Logger.d("2");
                            if (listBean.getVideo_3() != null) {
                                return updateVideoBean(listBean.getVideo_3());
                            }
                            if (listBean.getVideo_2() != null) {
                                return updateVideoBean(listBean.getVideo_2());
                            }
                            if (listBean.getVideo_1() != null) {
                                return updateVideoBean(listBean.getVideo_1());
                            }
                        }
                        Logger.d("null");
                        return null;
                    }

                    private VideoAddressBean.DataBean.VideoListBean.VideoBean updateVideoBean(VideoAddressBean.DataBean.VideoListBean.VideoBean videoBean) {
                        String originalAddress = videoBean.getMain_url();
                        videoBean.setMain_url(new String(Base64.decode(originalAddress.getBytes(), Base64.DEFAULT)));
                        return videoBean;
                    }
                })
                .compose(TransformUtils.<VideoAddressBean.DataBean.VideoListBean.VideoBean>defaultSchedulers())
                .compose(mView.<VideoAddressBean.DataBean.VideoListBean.VideoBean>bindToLife())
                .subscribe(new Consumer<VideoAddressBean.DataBean.VideoListBean.VideoBean>() {
                    @Override
                    public void accept(VideoAddressBean.DataBean.VideoListBean.VideoBean videoBean) throws Exception {
                        mView.loadVideoAddress(videoBean, position);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.d(throwable.getMessage());
                    }
                });
    }
}
