package com.xu.headline.ui.activity.commentreply;

import android.content.Intent;

import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.base.BaseActivity;
import com.xu.headline.bean.CommentReplyListBean;
import com.xu.headline.bean.CommentReplyThemeBean;

/**
 * Created by xusn10 on 2018/3/6.
 *
 * @author xusn10
 *         评论回复activity
 */

public class CommentReplyActivity extends BaseActivity<ICommentReplyContract.ICommentReplyPresenter> implements ICommentReplyContract.ICommentReplyView {
    @Override
    public int setLayoutId() {
        return R.layout.activity_comment_reply;
    }

    @Override
    public void initOthers() {
        super.initOthers();
        Intent intent = getIntent();
        long commentID = intent.getLongExtra("commentID", 0);
        if (commentID != 0) {
            mPresenter.getCommentReplyData(commentID);
        }
    }

    @Override
    public ICommentReplyContract.ICommentReplyPresenter setPresenter() {
        return new CommentReplyPresenter();
    }

    @Override
    public void loadCommentReplyTheme(CommentReplyThemeBean commentReplyThemeBean) {
        Logger.d(commentReplyThemeBean.getData().getText());
    }

    @Override
    public void loadCommentReplyList(CommentReplyListBean commentReplyListBean) {

    }
}
