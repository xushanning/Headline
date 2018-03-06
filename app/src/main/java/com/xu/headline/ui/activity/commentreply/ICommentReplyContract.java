package com.xu.headline.ui.activity.commentreply;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.CommentReplyListBean;
import com.xu.headline.bean.CommentReplyThemeBean;

/**
 * Created by xusn10 on 2018/3/6.
 *
 * @author xusn10
 */

public interface ICommentReplyContract {
    interface ICommentReplyView extends IBaseContract.IBaseView {
        /**
         * 加载评论主题信息
         *
         * @param commentReplyThemeBean 信息实体类
         */
        void loadCommentReplyTheme(CommentReplyThemeBean commentReplyThemeBean);

        /**
         * 加载热门评论回复和全部回复
         *
         * @param commentReplyListBean 实体类
         */
        void loadCommentReplyList(CommentReplyListBean commentReplyListBean);
    }

    interface ICommentReplyPresenter extends IBaseContract.IBasePresenter<ICommentReplyView> {
        /**
         * 获取评论回复数据
         *
         * @param commentID 评论id
         */
        void getCommentReplyData(long commentID);
    }
}
