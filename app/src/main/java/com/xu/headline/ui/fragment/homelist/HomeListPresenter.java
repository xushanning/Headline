package com.xu.headline.ui.fragment.homelist;

import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseShowApiResBean;
import com.xu.headline.bean.NewsListBean;
import com.xu.headline.net.BaseHttpResultObserver;
import com.xu.headline.net.HttpConstants;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.TransformUtils;

/**
 * Created by xusn10 on 2018/1/18.
 *
 * @author xu
 */

public class HomeListPresenter extends BasePresenter<IHomeListContract.IHomeListView> implements IHomeListContract.IHomeListPresenter {

    @Override
    public void getNewsList(String channelID, final int page) {
        RetrofitFactory.getNewsApi()
                .getNewsList(HttpConstants.SHOW_API_APP_ID, HttpConstants.SHOW_API_SECRET, channelID, page)
                .compose(mView.<BaseShowApiResBean<NewsListBean>>bindToLife())
                .compose(TransformUtils.<BaseShowApiResBean<NewsListBean>>defaultSchedulers())
                .subscribe(new BaseHttpResultObserver<NewsListBean>() {
                    @Override
                    protected void onSuccess(NewsListBean newsListBean) {
                        if (page == 1) {
                            mView.loadNewsList(newsListBean);
                        } else {
                            mView.loadMoreData(newsListBean);
                        }
                    }
                });
    }
}
