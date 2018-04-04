package com.xu.headline.ui.fragment.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.orhanobut.logger.Logger;
import com.xu.headline.MyApplication;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.VideoChannelBean;
import com.xu.headline.db.SubscribeChannelDbBeanDao;
import com.xu.headline.db.VideoChannelDbBeanDao;
import com.xu.headline.db.dbbean.VideoChannelDbBean;
import com.xu.headline.net.HttpConstants;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.TransformUtils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class VideoPresenter extends BasePresenter<IVideoContract.IVideoView> implements IVideoContract.IVideoPresenter {
    /**
     * 数据库中的频道有效时间为24小时，超过24小时，需要重新联网获取
     */
    private static final int EFFECTIVE_TIME = 86400;

    /**
     * 将毫秒转换成秒
     */
    private static final int MINUTE = 1000;

    @Override
    public void initVideoChannel() {
        TelephonyManager telephonyManager = (TelephonyManager) MyApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission")     final String iMei = telephonyManager.getDeviceId();
        Observable<List<VideoChannelBean>> dataBaseObservable = Observable.create(new ObservableOnSubscribe<List<VideoChannelBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<VideoChannelBean>> e) throws Exception {
                VideoChannelDbBeanDao channelDbBeanDao = MyApplication.getInstance().getDaoSession().getVideoChannelDbBeanDao();
                VideoChannelDbBean channelDbBean = channelDbBeanDao.queryBuilder().where(SubscribeChannelDbBeanDao.Properties.IMei.eq(iMei)).build().unique();
                if (channelDbBean == null) {
                    Logger.d("数据库中为null");
                    //为null，直接执行下一个observable
                    e.onComplete();
                } else {
                    Logger.d("数据库中有数据");
                    if (System.currentTimeMillis() / MINUTE - channelDbBean.getTime() > EFFECTIVE_TIME) {
                        //结束，请求网络
                        e.onComplete();
                    } else {
                        //在有效期内，发送频道
                        e.onNext(channelDbBean.getChannels());
                    }

                }
            }
        }).subscribeOn(Schedulers.io());

        Observable<List<VideoChannelBean>> netWorkObservable =
                RetrofitFactory.
                        getTouTiaoApi()
                        .getVideoChannelList()
                        .map(new Function<BaseResBean<List<VideoChannelBean>>, List<VideoChannelBean>>() {
                            @Override
                            public List<VideoChannelBean> apply(BaseResBean<List<VideoChannelBean>> listBaseResBean) throws Exception {
                                return HttpConstants.REQUEST_SUCCESS.equals(listBaseResBean.getMessage()) ? listBaseResBean.getData() : null;
                            }
                        })
                        .doOnNext(new Consumer<List<VideoChannelBean>>() {
                            @Override
                            public void accept(List<VideoChannelBean> videoChannelBeans) throws Exception {
                                if (videoChannelBeans != null) {
                                    //入库

                                    //看是否有，如果有，那么更新
                                    VideoChannelDbBeanDao channelDbBeanDao = MyApplication.getInstance().getDaoSession().getVideoChannelDbBeanDao();
                                    VideoChannelDbBean dbBeanLocal = channelDbBeanDao.queryBuilder().where(SubscribeChannelDbBeanDao.Properties.IMei.eq(iMei)).build().unique();
                                    if (dbBeanLocal == null) {
                                        //无数据，插入
                                        VideoChannelDbBean dbBean = new VideoChannelDbBean();
                                        dbBean.setIMei(iMei);
                                        dbBean.setTime(System.currentTimeMillis() / 1000);
                                        dbBean.setChannels(videoChannelBeans);
                                        channelDbBeanDao.insert(dbBean);
                                    } else {
                                        //有数据,更新
                                        dbBeanLocal.setTime(System.currentTimeMillis() / 1000);
                                        dbBeanLocal.setChannels(videoChannelBeans);
                                        channelDbBeanDao.update(dbBeanLocal);
                                    }
                                }
                            }
                        }).subscribeOn(Schedulers.io());

        Observable.concat(dataBaseObservable, netWorkObservable)
                .compose(TransformUtils.<List<VideoChannelBean>>defaultSchedulers())
                .compose(mView.<List<VideoChannelBean>>bindToLife())
                .firstElement()
                .subscribe(new Consumer<List<VideoChannelBean>>() {
                    @Override
                    public void accept(List<VideoChannelBean> videoChannelBeans) throws Exception {
                        mView.loadVideoChannel(videoChannelBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.d(throwable.getMessage());
                    }
                });


    }
}
