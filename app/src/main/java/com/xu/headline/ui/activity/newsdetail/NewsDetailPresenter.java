package com.xu.headline.ui.activity.newsdetail;

import com.orhanobut.logger.Logger;
import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.NewsDetailsBean;
import com.xu.headline.net.BaseTouTiaoResObserver;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.TransformUtils;

/**
 * Created by xusn10 on 2018/1/19.
 *
 * @author xu
 */

public class NewsDetailPresenter extends BasePresenter<INewsDetailContract.INewsDetailView> implements INewsDetailContract.INewsDetailPresenter {


    @Override
    public void getNewsDetailsData(long newsID) {
        RetrofitFactory.getTouTiaoArticleApi()
                .getNewsDetails(newsID)
                .compose(mView.<BaseResBean<NewsDetailsBean>>bindToLife())
                .compose(TransformUtils.<BaseResBean<NewsDetailsBean>>defaultSchedulers())
                .subscribe(new BaseTouTiaoResObserver<NewsDetailsBean>() {
                    @Override
                    protected void onSuccess(NewsDetailsBean newsDetailsBean) {
                        Logger.d(newsDetailsBean.getH5_extra().getTitle());

                    }
                });
    }
}
