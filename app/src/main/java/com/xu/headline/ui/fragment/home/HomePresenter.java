package com.xu.headline.ui.fragment.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.orhanobut.logger.Logger;
import com.xu.headline.MyApplication;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseResBean;
import com.xu.headline.base.BaseShowApiResBean;
import com.xu.headline.base.SuggestSearchBean;
import com.xu.headline.bean.NewsChannelListBean;
import com.xu.headline.db.SubscribeChannelDbBeanDao;
import com.xu.headline.db.dbbean.SubscribeChannelDbBean;
import com.xu.headline.net.BaseTouTiaoResObserver;
import com.xu.headline.net.HttpConstants;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.TransformUtils;

import java.util.ArrayList;
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

public class HomePresenter extends BasePresenter<IHomeContract.IHomeView> implements IHomeContract.IHomePresenter {
    /**
     * 默认加载频道数为5
     */
    private static final int DEFAULT_CHANNEL_COUNT = 7;

    @Override
    public void initChannel() {
        TelephonyManager telephonyManager = (TelephonyManager) MyApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") final String iMei = telephonyManager.getDeviceId();

        Observable<List<NewsChannelListBean.ChannelListBean>> dataBaseObservable = Observable.create(new ObservableOnSubscribe<List<NewsChannelListBean.ChannelListBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<NewsChannelListBean.ChannelListBean>> e) throws Exception {
                SubscribeChannelDbBeanDao channelDbBeanDao = MyApplication.getInstance().getDaoSession().getSubscribeChannelDbBeanDao();
                SubscribeChannelDbBean channelDbBean = channelDbBeanDao.queryBuilder().where(SubscribeChannelDbBeanDao.Properties.IMei.eq(iMei)).build().unique();
                if (channelDbBean == null) {
                    Logger.d("数据库中为null");
                    //为null，直接执行下一个observable
                    e.onComplete();
                } else {
                    Logger.d("数据库中有数据");
                    e.onNext(channelDbBean.getChannels());
                }
            }
        });
        Observable<List<NewsChannelListBean.ChannelListBean>> netWorkObservable =
                RetrofitFactory.getNewsApi().
                        getChannelList(HttpConstants.SHOW_API_APP_ID, HttpConstants.SHOW_API_SECRET).
                        map(new Function<BaseShowApiResBean<NewsChannelListBean>, List<NewsChannelListBean.ChannelListBean>>() {
                            @Override
                            public List<NewsChannelListBean.ChannelListBean> apply(BaseShowApiResBean<NewsChannelListBean> resBean) throws Exception {
                                List<NewsChannelListBean.ChannelListBean> resList = resBean.getResBody().getChannelList();
                                if (resBean.getResCode() == 0 && resList != null) {
                                    List<NewsChannelListBean.ChannelListBean> resultList = new ArrayList<>();
                                    //默认频道数量为7，如果网络访问到的频道数小于或者等于默认的7，那么长度为网络访问的长度，否则，就是7
                                    int count = resList.size() <= DEFAULT_CHANNEL_COUNT ? resList.size() : DEFAULT_CHANNEL_COUNT;
                                    //由于接口出来的频道名称略长，做一下处理，如：国内焦点--->国内
                                    for (int i = 0; i < count; i++) {
                                        NewsChannelListBean.ChannelListBean newChannelBean = new NewsChannelListBean.ChannelListBean();
                                        newChannelBean.setChannelId(resList.get(i).getChannelId());
                                        newChannelBean.setChannelName(resList.get(i).getChannelName().substring(0, resList.get(i).getChannelName().length() - 2));
                                        resultList.add(newChannelBean);
                                    }
                                    return resultList;
                                }
                                return null;
                            }
                        }).
                        doOnNext(new Consumer<List<NewsChannelListBean.ChannelListBean>>() {
                            @Override
                            public void accept(List<NewsChannelListBean.ChannelListBean> channelListBeans) throws Exception {
                                //请求成功，存数据库
                                if (channelListBeans != null) {
                                    SubscribeChannelDbBeanDao channelDbBeanDao = MyApplication.getInstance().getDaoSession().getSubscribeChannelDbBeanDao();
                                    SubscribeChannelDbBean dbBean = new SubscribeChannelDbBean();
                                    dbBean.setIMei(iMei);
                                    dbBean.setChannels(channelListBeans);
                                    channelDbBeanDao.insert(dbBean);
                                }
                            }
                        }).subscribeOn(Schedulers.io());
        //且只有前一个 Observable 终止(onComplete) 后才会订阅下一个 Observable
        Observable.concat(dataBaseObservable, netWorkObservable)
                .compose(mView.<List<NewsChannelListBean.ChannelListBean>>bindToLife())
                .compose(TransformUtils.<List<NewsChannelListBean.ChannelListBean>>defaultSchedulers())
                .subscribe(new Consumer<List<NewsChannelListBean.ChannelListBean>>() {
                    @Override
                    public void accept(List<NewsChannelListBean.ChannelListBean> channelListBeans) throws Exception {
                        mView.loadData(channelListBeans);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Logger.d(throwable.getMessage());
                    }
                });


    }

    @Override
    public void getSuggestSearch() {
        RetrofitFactory.getTouTiaoApi()
                .getSuggestSearch()
                .compose(mView.<BaseResBean<SuggestSearchBean>>bindToLife())
                .compose(TransformUtils.<BaseResBean<SuggestSearchBean>>defaultSchedulers())
                .subscribe(new BaseTouTiaoResObserver<SuggestSearchBean>() {
                    @Override
                    protected void onSuccess(SuggestSearchBean suggestSearchBean) {
                        mView.loadSuggestSearch(suggestSearchBean.getHomepageSearchSuggest());
                    }
                });

    }
}
