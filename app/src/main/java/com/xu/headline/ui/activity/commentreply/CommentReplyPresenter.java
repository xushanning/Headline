package com.xu.headline.ui.activity.commentreply;

import com.xu.headline.base.BasePresenter;
import com.xu.headline.bean.CommentReplyListBean;
import com.xu.headline.bean.CommentReplyThemeBean;
import com.xu.headline.net.RetrofitFactory;
import com.xu.headline.net.RetryRequestWithDelay;
import com.xu.headline.net.TouTiaoApi;
import com.xu.headline.net.TouTiaoApiService;
import com.xu.headline.utils.TransformUtils;

import io.reactivex.functions.Consumer;

/**
 * Created by xusn10 on 2018/3/6.
 *
 * @author xusn10
 */

public class CommentReplyPresenter extends BasePresenter<ICommentReplyContract.ICommentReplyView> implements ICommentReplyContract.ICommentReplyPresenter {
    @Override
    public void getCommentReplyData(long commentID) {
        //评论主题
        RetrofitFactory.getTouTiaoApi()
                .getCommentReplyTheme(commentID)
                .compose(mView.<CommentReplyThemeBean>bindToLife())
                .compose(TransformUtils.<CommentReplyThemeBean>defaultSchedulers())
                .subscribe(new Consumer<CommentReplyThemeBean>() {
                    @Override
                    public void accept(CommentReplyThemeBean commentReplyThemeBean) throws Exception {
                        mView.loadCommentReplyTheme(commentReplyThemeBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
        //热门回复和全部回复
        RetrofitFactory.getTouTiaoApi()
                .getCommentReplyList(commentID)
                .retryWhen(new RetryRequestWithDelay(3, 3000))
                .compose(mView.<CommentReplyListBean>bindToLife())
                .compose(TransformUtils.<CommentReplyListBean>defaultSchedulers())
                .subscribe(new Consumer<CommentReplyListBean>() {
                    @Override
                    public void accept(CommentReplyListBean commentReplyListBean) throws Exception {
                        mView.loadCommentReplyList(commentReplyListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
