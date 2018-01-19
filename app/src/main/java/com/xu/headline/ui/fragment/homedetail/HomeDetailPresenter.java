package com.xu.headline.ui.fragment.homedetail;

import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseResBean;
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

public class HomeDetailPresenter extends BasePresenter<IHomeDetailContract.IHomeDetailView> implements IHomeDetailContract.IHomeDetailPresenter {

    @Override
    public void getNewsList(String channel) {
        RetrofitFactory.getTouTiaoApi()
                .getNewsList(channel, 0, 30, HttpConstants.APP_KEY)
                .compose(mView.<BaseResBean<NewsListBean>>bindToLife())
                .compose(TransformUtils.<BaseResBean<NewsListBean>>defaultSchedulers())
                .subscribe(new BaseHttpResultObserver<NewsListBean>() {
                    @Override
                    protected void onSuccess(NewsListBean newsListBean) {
                        mView.loadNewsList(newsListBean);
                    }
                });
    }
}
