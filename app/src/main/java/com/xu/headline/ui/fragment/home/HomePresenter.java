package com.xu.headline.ui.fragment.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.orhanobut.logger.Logger;
import com.xu.headline.MyApplication;
import com.xu.headline.R;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.bean.ChannelBean;
import com.xu.headline.bean.ShowApiChannelListBean;
import com.xu.headline.db.SubscribeChannelDbBeanDao;
import com.xu.headline.db.dbbean.SubscribeChannelDbBean;
import com.xu.headline.utils.TransformUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public class HomePresenter extends BasePresenter<IHomeContract.IHomeView> implements IHomeContract.IHomePresenter {
    /**
     * 默认加载频道数为5
     */
    private static final int DEFAULT_CHANNEL_COUNT = 5;

    @Override
    public void initChannel() {
        TelephonyManager telephonyManager = (TelephonyManager) MyApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") final String iMei = telephonyManager.getDeviceId();
        Logger.d("imei" + iMei);


        Observable.create(new ObservableOnSubscribe<List<ShowApiChannelListBean.ChannelListBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ShowApiChannelListBean.ChannelListBean>> e) throws Exception {

            }
        }).flatMap(new Function<List<ShowApiChannelListBean.ChannelListBean>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(List<ShowApiChannelListBean.ChannelListBean> channelListBeans) throws Exception {
                if (channelListBeans == null) {

                }
                return null;
            }
        });
//        Observable<List<ShowApiChannelListBean.ChannelListBean>> netWorkObservable =
//                RetrofitFactory.getNewsApi().getChannelList(HttpConstants.SHOW_API_APP_ID, HttpConstants.SHOW_API_SECRET).flatMap(new Function<BaseShowApiResBean<ShowApiChannelListBean>, ObservableSource<ShowApiChannelListBean>>() {
//                    @Override
//                    public ObservableSource<ShowApiChannelListBean> apply(BaseShowApiResBean<ShowApiChannelListBean> resBean) throws Exception {
//                        if (resBean.getResCode() == 0) {
//                            return Observable.create(new ObservableOnSubscribe<ShowApiChannelListBean>() {
//
//                                @Override
//                                public void subscribe(ObservableEmitter<ShowApiChannelListBean> e) throws Exception {
//
//                                }
//                            });
//                        }
//                        return null;
//                    }
//                });

        Observable.create(new ObservableOnSubscribe<List<ChannelBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ChannelBean>> e) throws Exception {
                SubscribeChannelDbBeanDao channelDbBeanDao = MyApplication.getInstance().getDaoSession().getSubscribeChannelDbBeanDao();
                SubscribeChannelDbBean channelDbBean = channelDbBeanDao.queryBuilder().where(SubscribeChannelDbBeanDao.Properties.IMei.eq(iMei)).build().unique();
                List<ChannelBean> channels;
                //说明数据库里有数据
                if (channelDbBean != null) {
                    //  channels = channelDbBean.getChannels();
                } else {
                    //没数据，数据库里加入默认的数据
                    channels = new ArrayList<>();
                    List<String> channelName = Arrays.asList(MyApplication.getContext().getResources()
                            .getStringArray(R.array.newsChannel));
                    List<String> channelId = Arrays.asList(MyApplication.getContext().getResources()
                            .getStringArray(R.array.newsChannelId));
                    for (int i = 0; i < DEFAULT_CHANNEL_COUNT; i++) {
                        ChannelBean channelBean = new ChannelBean();
                        channelBean.setChannelName(channelName.get(i));
                        channelBean.setChannelID(channelId.get(i));
                        channels.add(channelBean);
                    }
                    SubscribeChannelDbBean channelDbBeanInsert = new SubscribeChannelDbBean();
                    channelDbBeanInsert.setIMei(iMei);
                    //  channelDbBeanInsert.setChannels(channels);
                    //入库
                    channelDbBeanDao.insert(channelDbBeanInsert);
                }

                // e.onNext(channels);
                e.onComplete();
            }
        }).compose(mView.<List<ChannelBean>>bindToLife())
                .compose(TransformUtils.<List<ChannelBean>>defaultSchedulers())
                .subscribe(new Consumer<List<ChannelBean>>() {
                    @Override
                    public void accept(List<ChannelBean> list) throws Exception {
                        mView.loadData(list);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.d(throwable.getMessage());
                    }
                });

    }
}
