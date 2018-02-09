package com.xu.headline.ui.fragment.homelist;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.xu.headline.adapter.MultiNewsItem;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.bean.TouTiaoListItemBean;
import com.xu.headline.bean.TouTiaoNewsListBean;
import com.xu.headline.net.HttpConstants;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.SharedPreUtil;
import com.xu.headline.utils.TransformUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by xusn10 on 2018/1/18.
 *
 * @author xu
 */

public class HomeListPresenter extends BasePresenter<IHomeListContract.IHomeListView> implements IHomeListContract.IHomeListPresenter {

    @Override
    public void getNewsList(final String channelID, final int actionType) {
        //最后一次刷新时间
        long lastRefreshTime = SharedPreUtil.getLong("channelID", System.currentTimeMillis() / 1000);
        Logger.d("上一次刷新时间:" + lastRefreshTime);
        RetrofitFactory.getTouTiaoApi()
                .getNewsList(channelID, lastRefreshTime)
                .map(new Function<TouTiaoNewsListBean, List<MultiNewsItem>>() {
                    @Override
                    public List<MultiNewsItem> apply(TouTiaoNewsListBean touTiaoNewsListBean) throws Exception {
                        if (HttpConstants.REQUEST_SUCCESS.equals(touTiaoNewsListBean.getMessage())) {
                            List<MultiNewsItem> items = new ArrayList<>(touTiaoNewsListBean.getData().size());
                            for (TouTiaoNewsListBean.DataBean dataBean : touTiaoNewsListBean.getData()) {
                                String itemString = dataBean.getContent();
                                //返回的字符串不符合标准json，处理一下
                                String handleString = itemString.replace("\\", "").replace("\"{", "{").replace("}\"", "}");
                                TouTiaoListItemBean itemBean = new Gson().fromJson(handleString, TouTiaoListItemBean.class);
                                int itemType = 1;
                                //是否有图片
                                if (itemBean.isHas_image()) {
                                    if (itemBean.getImage_list() != null) {
                                        //多图
                                        itemType = MultiNewsItem.MULTI_IMG_NEWS;
                                    } else {
                                        if (itemBean.getMiddle_image() != null) {
                                            //右边小图都是middle
                                            itemType = MultiNewsItem.SINGLE_SMALL_IMG_NEWS;
                                        }
                                    }

                                } else {
                                    //无图片，分为两种情况，一种纯text的item，另外一种是广告
                                    if (itemBean.getLarge_image_list() != null) {
                                        //广告
                                        itemType = MultiNewsItem.AD_NEWS;
                                    } else {
                                        itemType = MultiNewsItem.TEXT_NEWS;
                                    }

                                }
                                MultiNewsItem multiNewsItem = new MultiNewsItem(itemType);
                                multiNewsItem.setItemBean(itemBean);
                                items.add(multiNewsItem);
                            }

                            return items;
                        }
                        return null;
                    }
                })
                .compose(mView.<List<MultiNewsItem>>bindToLife())
                .compose(TransformUtils.<List<MultiNewsItem>>defaultSchedulers())
                .subscribe(new Consumer<List<MultiNewsItem>>() {
                    @Override
                    public void accept(List<MultiNewsItem> multiNewsItems) throws Exception {
                        mView.loadNewsList(multiNewsItems, actionType);
                        SharedPreUtil.putLong(channelID, System.currentTimeMillis() / 1000);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
