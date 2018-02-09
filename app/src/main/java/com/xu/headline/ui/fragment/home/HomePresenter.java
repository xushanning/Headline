package com.xu.headline.ui.fragment.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;

import com.orhanobut.logger.Logger;
import com.xu.headline.MyApplication;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.SuggestSearchBean;
import com.xu.headline.bean.NewsSuggestChannelBean;
import com.xu.headline.db.SubscribeChannelDbBeanDao;
import com.xu.headline.db.dbbean.SubscribeChannelDbBean;
import com.xu.headline.net.BaseTouTiaoResObserver;
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

public class HomePresenter extends BasePresenter<IHomeContract.IHomeView> implements IHomeContract.IHomePresenter {
    /**
     * 默认加载频道数为5
     */
    private static final int DEFAULT_CHANNEL_COUNT = 7;

    /**
     * 数据库中的频道有效时间为24小时，超过24小时，需要重新联网获取
     */
    private static final int EFFECTIVE_TIME = 86400;

    /**
     * 将毫秒转换成秒
     */
    private static final int MINUTE = 1000;

    @Override
    public void initChannel() {
        TelephonyManager telephonyManager = (TelephonyManager) MyApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission") final String iMei = telephonyManager.getDeviceId();

        Observable<List<NewsSuggestChannelBean.DataBean>> dataBaseObservable = Observable.create(new ObservableOnSubscribe<List<NewsSuggestChannelBean.DataBean>>() {
            @Override
            public void subscribe(ObservableEmitter<List<NewsSuggestChannelBean.DataBean>> e) throws Exception {
                SubscribeChannelDbBeanDao channelDbBeanDao = MyApplication.getInstance().getDaoSession().getSubscribeChannelDbBeanDao();
                SubscribeChannelDbBean channelDbBean = channelDbBeanDao.queryBuilder().where(SubscribeChannelDbBeanDao.Properties.IMei.eq(iMei)).build().unique();
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
        Observable<List<NewsSuggestChannelBean.DataBean>> netWorkObservable =
                RetrofitFactory.getTouTiaoApi()
                        .getSuggestChannel()
                        .map(new Function<BaseResBean<NewsSuggestChannelBean>, List<NewsSuggestChannelBean.DataBean>>() {
                            @Override
                            public List<NewsSuggestChannelBean.DataBean> apply(BaseResBean<NewsSuggestChannelBean> baseResBean) throws Exception {
                                return HttpConstants.REQUEST_SUCCESS.equals(baseResBean.getMessage()) ? baseResBean.getData().getData() : null;
                            }
                        })
                        .doOnNext(new Consumer<List<NewsSuggestChannelBean.DataBean>>() {
                            @Override
                            public void accept(List<NewsSuggestChannelBean.DataBean> channelListBeans) throws Exception {
                                //请求成功，存数据库
                                if (channelListBeans != null) {
                                    SubscribeChannelDbBeanDao channelDbBeanDao = MyApplication.getInstance().getDaoSession().getSubscribeChannelDbBeanDao();
                                    SubscribeChannelDbBean dbBean = new SubscribeChannelDbBean();
                                    dbBean.setIMei(iMei);
                                    dbBean.setTime(System.currentTimeMillis() / 1000);
                                    dbBean.setChannels(channelListBeans);
                                    channelDbBeanDao.insert(dbBean);
                                }
                            }
                        }).subscribeOn(Schedulers.io());
        //且只有前一个 Observable 终止(onComplete) 后才会订阅下一个 Observable
        Observable.concat(dataBaseObservable, netWorkObservable)
                .compose(mView.<List<NewsSuggestChannelBean.DataBean>>bindToLife())
                .compose(TransformUtils.<List<NewsSuggestChannelBean.DataBean>>defaultSchedulers())
                .subscribe(new Consumer<List<NewsSuggestChannelBean.DataBean>>() {
                    @Override
                    public void accept(List<NewsSuggestChannelBean.DataBean> channelListBeans) throws Exception {
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
