package com.xu.headline.ui.activity.newsdetail;

import com.xu.headline.base.BasePresenter;
import com.xu.headline.base.BaseResBean;
import com.xu.headline.bean.response.CommentListBean;
import com.xu.headline.bean.response.authorinfo.AuthorInfoBean;
import com.xu.headline.bean.response.NewsDetailsBean;
import com.xu.headline.net.BaseTouTiaoResObserver;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.utils.TransformUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by xusn10 on 2018/1/19.
 *
 * @author xu
 */

public class NewsDetailPresenter extends BasePresenter<INewsDetailContract.INewsDetailView> implements INewsDetailContract.INewsDetailPresenter {


    @Override
    public void getNewsDetailsData(long newsID, String channelID) {
        RetrofitFactory.getTouTiaoArticleApi()
                .getNewsDetails(newsID)
                .compose(mView.<BaseResBean<NewsDetailsBean>>bindToLife())
                .compose(TransformUtils.<BaseResBean<NewsDetailsBean>>defaultSchedulers())
                .subscribe(new BaseTouTiaoResObserver<NewsDetailsBean>() {
                    @Override
                    protected void onSuccess(NewsDetailsBean newsDetailsBean) {
                        mView.loadNewsDetailsData(newsDetailsBean);
                    }
                });
        RetrofitFactory.getTouTiaoApi()
                .getAuthorInfo(newsID, channelID)
                .compose(mView.<BaseResBean<AuthorInfoBean>>bindToLife())
                .compose(TransformUtils.<BaseResBean<AuthorInfoBean>>defaultSchedulers())
                .subscribe(new BaseTouTiaoResObserver<AuthorInfoBean>() {
                    @Override
                    protected void onSuccess(AuthorInfoBean authorInfoBean) {
                        mView.loadAuthorInfo(authorInfoBean);
                    }
                });
        RetrofitFactory.getTouTiaoApi()
                .getCommentList(newsID, channelID)
                .compose(mView.<CommentListBean>bindToLife())
                .compose(TransformUtils.<CommentListBean>defaultSchedulers())
                .subscribe(new Consumer<CommentListBean>() {
                    @Override
                    public void accept(CommentListBean commentListBean) throws Exception {
                        mView.loadCommentList(commentListBean);
                    }
                });
    }
}
