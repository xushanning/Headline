package com.xu.headline.ui.fragment.videolist;

import com.orhanobut.logger.Logger;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.bean.response.TouTiaoNewsVideoItemBean;
import com.xu.headline.bean.response.TouTiaoNewsVideoListBean;
import com.xu.headline.net.HttpConstants;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.SharedPreUtil;
import com.xu.headline.utils.TransformUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/18.
 *
 * @author xu
 */

public class VideoListPresenter extends BasePresenter<IVideoListContract.IVideoListView> implements IVideoListContract.IVideoListPresenter {


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
}
