package com.xu.headline.ui.fragment.homelist;

import com.google.gson.Gson;
import com.xu.headline.adapter.MultiNewsItem;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.bean.TouTiaoListItemBean;
import com.xu.headline.bean.TouTiaoNewsListBean;
import com.xu.headline.net.HttpConstants;
import com.xu.headline.net.RetrofitFactory;
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
    public void getNewsList(String channelID, final int page) {
//        RetrofitFactory.getNewsApi()
//                .getNewsList(HttpConstants.SHOW_API_APP_ID, HttpConstants.SHOW_API_SECRET, channelID, page)
//                .compose(mView.<BaseShowApiResBean<NewsListBean>>bindToLife())
//                .compose(TransformUtils.<BaseShowApiResBean<NewsListBean>>defaultSchedulers())
//                .subscribe(new BaseHttpResultObserver<NewsListBean>() {
//                    @Override
//                    protected void onSuccess(NewsListBean newsListBean) {
//                        if (page == 1) {
//                            mView.loadNewsList(newsListBean);
//                        } else {
//                            mView.loadMoreData(newsListBean);
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        if (page == 1) {
//                            mView.loadNewsList(null);
//                        } else {
//                            mView.loadMoreData(null);
//                        }
//                    }
//                });
        RetrofitFactory.getTouTiaoApi()
                .getNewsList("news_hot", 1517903824)
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
                                //是否有图片，没有，纯text的item
                                if (itemBean.isHas_image()) {

                                } else {
                                    //无图片
                                    itemType = MultiNewsItem.TEXT_NEWS;
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
                        mView.loadNewsList(multiNewsItems);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
