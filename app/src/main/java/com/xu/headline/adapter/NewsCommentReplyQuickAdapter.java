package com.xu.headline.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xu.headline.MyApplication;
import com.xu.headline.R;
import com.xu.headline.bean.response.CommentReplyListBean;
import com.xu.headline.utils.CommentEmojiUtil;
import com.xu.headline.utils.ImageLoaderUtil;
import com.xu.headline.utils.TimeUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 *
 * @author xu
 *         评论回复的列表adapter
 */

public class NewsCommentReplyQuickAdapter extends BaseQuickAdapter<CommentReplyListBean.DataBeanX.CommentsBean, BaseViewHolder> {
    public NewsCommentReplyQuickAdapter(@Nullable List<CommentReplyListBean.DataBeanX.CommentsBean> data) {
        super(R.layout.item_news_details_comment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentReplyListBean.DataBeanX.CommentsBean item) {
        helper.getView(R.id.tv_single_comment_reply_count).setVisibility(View.GONE);
        helper.setText(R.id.tv_user_name, item.getUser().getName())
                .setText(R.id.tv_appreciate_count, MyApplication.getContext().getString(R.string.x_only_digit, item.getDigg_count()))
                .setText(R.id.tv_comment, CommentEmojiUtil.getEmojiString(item.getText()))
                .setText(R.id.tv_comment_time, TimeUtil.transformNewsPublishTime(item.getCreate_time()));
        ImageLoaderUtil.loadCircleImage(MyApplication.getContext(), item.getUser().getAvatar_url(), (ImageView) helper.getView(R.id.img_user_portrait));
    }
}
