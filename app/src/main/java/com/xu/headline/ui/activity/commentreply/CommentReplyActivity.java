package com.xu.headline.ui.activity.commentreply;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.adapter.NewsCommentReplyQuickAdapter;
import com.xu.headline.base.BaseActivity;
import com.xu.headline.bean.CommentReplyListBean;
import com.xu.headline.bean.CommentReplyThemeBean;
import com.xu.headline.utils.ImageLoaderUtil;
import com.xu.headline.utils.TimeUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by xusn10 on 2018/3/6.
 *
 * @author xusn10
 *         评论回复activity
 */

public class CommentReplyActivity extends BaseActivity<ICommentReplyContract.ICommentReplyPresenter> implements ICommentReplyContract.ICommentReplyView {
    @BindView(R.id.tv_reply_count)
    TextView tvReplyCount;
    @BindView(R.id.img_be_reply)
    ImageView imgBeReply;
    @BindView(R.id.tv_be_reply_user_name)
    TextView tvBeReplyUserName;
    @BindView(R.id.tv_be_reply_comment)
    TextView tvBeReplyComment;
    @BindView(R.id.tv_comment_time)
    TextView tvCommentTime;
    @BindView(R.id.img_appreciate_1)
    ImageView imgAppreciate1;
    @BindView(R.id.img_appreciate_2)
    ImageView imgAppreciate2;
    @BindView(R.id.img_appreciate_3)
    ImageView imgAppreciate3;
    @BindView(R.id.tv_appreciate_count_left)
    TextView tvAppreciateCountLeft;
    @BindView(R.id.rv_comment_hot_reply)
    RecyclerView rvCommentHotReply;
    @BindView(R.id.rv_comment_all_reply)
    RecyclerView rvCommentAllReply;
    @BindView(R.id.tv_appreciate_count_right)
    TextView tvAppreciateCountRight;
    @BindView(R.id.tv_hot_reply)
    TextView tvHotReply;


    private NewsCommentReplyQuickAdapter hotReplyQuickAdapter;
    private NewsCommentReplyQuickAdapter allReplyQuickAdapter;

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
        initRecyclerView();
    }

    @Override
    public ICommentReplyContract.ICommentReplyPresenter setPresenter() {
        return new CommentReplyPresenter();
    }

    private void initRecyclerView() {
        hotReplyQuickAdapter = new NewsCommentReplyQuickAdapter(new ArrayList<CommentReplyListBean.DataBeanX.CommentsBean>());
        LinearLayoutManager hotReplyLinearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                //禁止recyclerView滑动
                return false;
            }
        };
        hotReplyLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvCommentHotReply.setLayoutManager(hotReplyLinearLayoutManager);
        rvCommentHotReply.setAdapter(hotReplyQuickAdapter);

        allReplyQuickAdapter = new NewsCommentReplyQuickAdapter(new ArrayList<CommentReplyListBean.DataBeanX.CommentsBean>());
        LinearLayoutManager allReplyLinearLayoutManager = new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                //禁止recyclerView滑动
                return false;
            }
        };
        allReplyLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvCommentAllReply.setLayoutManager(allReplyLinearLayoutManager);
        rvCommentAllReply.setAdapter(allReplyQuickAdapter);
    }

    @Override
    public void loadCommentReplyTheme(CommentReplyThemeBean commentReplyThemeBean) {
        CommentReplyThemeBean.DataBean dataBean = commentReplyThemeBean.getData();
        tvReplyCount.setText(getString(R.string.x_comment_count, dataBean.getComment_count()));
        ImageLoaderUtil.loadCircleImage(this, dataBean.getUser().getAvatar_url(), imgBeReply);
        tvBeReplyUserName.setText(dataBean.getUser().getScreen_name());
        tvBeReplyComment.setText(dataBean.getText());
        tvCommentTime.setText(TimeUtil.transformNewsPublishTime(dataBean.getCreate_time()));
        tvAppreciateCountLeft.setText(getString(R.string.x_appreciate_count, dataBean.getDigg_count()));
        tvAppreciateCountRight.setText(getString(R.string.x_only_digit, dataBean.getDigg_count()));

    }

    @Override
    public void loadCommentReplyList(CommentReplyListBean commentReplyListBean) {
        CommentReplyListBean.DataBeanX dataBeanX = commentReplyListBean.getData();
        List<CommentReplyListBean.DataBeanX.CommentsBean> dataBeanList = dataBeanX.getData();
        if (dataBeanList != null) {
            Logger.d("3");
            Logger.d(dataBeanList.size());
            for (int i = 0; i < dataBeanList.size(); i++) {
                if (i == 0) {
                    imgAppreciate1.setVisibility(View.VISIBLE);
                    ImageLoaderUtil.loadCircleImage(this, dataBeanList.get(i).getUser().getAvatar_url(), imgAppreciate1);
                } else if (i == 1) {
                    imgAppreciate2.setVisibility(View.VISIBLE);
                    ImageLoaderUtil.loadCircleImage(this, dataBeanList.get(i).getUser().getAvatar_url(), imgAppreciate2);
                } else if (i == 2) {
                    imgAppreciate3.setVisibility(View.VISIBLE);
                    ImageLoaderUtil.loadCircleImage(this, dataBeanList.get(i).getUser().getAvatar_url(), imgAppreciate3);
                }
            }
            allReplyQuickAdapter.addData(dataBeanList);
        } else {
            //隐藏全部评论
        }
        if (dataBeanX.getHot_comments() != null && dataBeanX.getHot_comments().size() != 0) {
            hotReplyQuickAdapter.addData(dataBeanX.getHot_comments());
        } else {
            tvHotReply.setVisibility(View.GONE);
        }
    }


    @OnClick({R.id.img_cancel, R.id.tv_pay_attention_to})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_cancel:
                break;
            case R.id.tv_pay_attention_to:
                break;
            default:
                break;
        }
    }


    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {

    }
}
