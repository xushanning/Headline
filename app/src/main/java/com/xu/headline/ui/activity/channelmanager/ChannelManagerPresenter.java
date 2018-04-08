package com.xu.headline.ui.activity.channelmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;

import com.orhanobut.logger.Logger;
import com.xu.headline.MyApplication;
import com.xu.headline.adapter.entity.MultiChannelManagerItem;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.NewsChannelListBean;
import com.xu.headline.db.SubscribeChannelDbBeanDao;
import com.xu.headline.db.dbbean.SubscribeChannelDbBean;
import com.xu.headline.net.HttpConstants;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.TransformUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/4/2.
 *
 * @author xu
 */

public class ChannelManagerPresenter extends BasePresenter<IChannelManagerContract.IChannelView> implements IChannelManagerContract.IChannelPresenter {
    private String iMei;

    @Override
    public void getRecommendChannelList() {
        TelephonyManager telephonyManager = (TelephonyManager) MyApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);

        if (ContextCompat.checkSelfPermission(MyApplication.getContext().getApplicationContext(), android.Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                iMei = telephonyManager.getImei(0);
            } else {
                iMei = telephonyManager.getDeviceId();
            }
        }

        //读取本地数据库
        Observable<List<MultiChannelManagerItem>> localItems = Observable.create(new ObservableOnSubscribe<List<MultiChannelManagerItem>>() {
            @Override
            public void subscribe(ObservableEmitter<List<MultiChannelManagerItem>> e) throws Exception {
                SubscribeChannelDbBeanDao channelDbBeanDao = MyApplication.getInstance().getDaoSession().getSubscribeChannelDbBeanDao();
                SubscribeChannelDbBean channelDbBean = channelDbBeanDao.queryBuilder().where(SubscribeChannelDbBeanDao.Properties.IMei.eq(iMei)).build().unique();
                List<NewsChannelListBean.ChannelBean> channelBeans = channelDbBean.getChannels();
                List<MultiChannelManagerItem> channelManagerItems = new ArrayList<>(channelBeans.size());
                //将第一条 我的频道放进去
                MultiChannelManagerItem channelManagerItem = new MultiChannelManagerItem(MultiChannelManagerItem.TYPE_MY_CHANNEL_TITLE);
                channelManagerItem.setSpanSize(4);
                channelManagerItems.add(channelManagerItem);
                for (NewsChannelListBean.ChannelBean channelBean : channelBeans) {
                    channelManagerItem = new MultiChannelManagerItem(MultiChannelManagerItem.TYPE_MY_CHANNEL);
                    channelManagerItem.setChannelBean(channelBean);
                    channelManagerItem.setSpanSize(1);
                    channelManagerItems.add(channelManagerItem);
                }
                e.onNext(channelManagerItems);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io());

        //网络获取
        Observable<List<MultiChannelManagerItem>> netItems = RetrofitFactory
                .getTouTiaoApi()
                .getRecommendChannelList()
                .map(new Function<BaseResBean<NewsChannelListBean>, List<MultiChannelManagerItem>>() {
                    @Override
                    public List<MultiChannelManagerItem> apply(BaseResBean<NewsChannelListBean> newsChannelListBeanBaseResBean) throws Exception {
                        if (newsChannelListBeanBaseResBean.getMessage().equals(HttpConstants.REQUEST_SUCCESS)) {
                            List<NewsChannelListBean.ChannelBean> channelBeans = newsChannelListBeanBaseResBean.getData().getData();
                            List<MultiChannelManagerItem> channelManagerItems = new ArrayList<>(channelBeans.size());
                            //将频道推荐 放进去
                            MultiChannelManagerItem channelManagerItem = new MultiChannelManagerItem(MultiChannelManagerItem.TYPE_RECOMMEND_CHANNEL_TITLE);
                            channelManagerItem.setSpanSize(4);
                            channelManagerItems.add(channelManagerItem);
                            for (NewsChannelListBean.ChannelBean channelBean : channelBeans) {
                                channelManagerItem = new MultiChannelManagerItem(MultiChannelManagerItem.TYPE_RECOMMEND_CHANNEL);
                                channelManagerItem.setChannelBean(channelBean);
                                channelManagerItem.setSpanSize(1);
                                channelManagerItems.add(channelManagerItem);
                            }
                            return channelManagerItems;
                        }
                        return null;
                    }
                }).subscribeOn(Schedulers.io());

        Observable.zip(localItems, netItems, new BiFunction<List<MultiChannelManagerItem>, List<MultiChannelManagerItem>, List<MultiChannelManagerItem>>() {
            @Override
            public List<MultiChannelManagerItem> apply(List<MultiChannelManagerItem> localItems, List<MultiChannelManagerItem> netItems) throws Exception {
                localItems.addAll(netItems);
                return localItems;
            }
        }).compose(TransformUtils.<List<MultiChannelManagerItem>>defaultSchedulers())
                .compose(mView.<List<MultiChannelManagerItem>>bindToLife())
                .subscribe(new Consumer<List<MultiChannelManagerItem>>() {
                    @Override
                    public void accept(List<MultiChannelManagerItem> multiChannelManagerItems) throws Exception {
                        mView.loadChannels(multiChannelManagerItems);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.d(throwable.getMessage());
                    }
                });

    }
}
