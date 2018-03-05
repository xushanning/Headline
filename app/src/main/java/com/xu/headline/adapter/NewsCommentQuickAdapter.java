package com.xu.headline.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xu.headline.MyApplication;
import com.xu.headline.R;
import com.xu.headline.bean.CommentListBean;
import com.xu.headline.utils.ImageLoaderUtil;
import com.xu.headline.utils.TimeUtil;

import java.util.List;

/**
 * Created by xusn10 on 2018/3/2.
 *
 * @author xu
 *         评论list的adapter
 */

public class NewsCommentQuickAdapter extends BaseQuickAdapter<CommentListBean.DataBean, BaseViewHolder> {

    public NewsCommentQuickAdapter(@Nullable List<CommentListBean.DataBean> data) {
        super(R.layout.item_news_details_comment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentListBean.DataBean item) {
        CommentListBean.DataBean.CommentBean commentBean = item.getComment();
        helper.setText(R.id.tv_user_name, commentBean.getUser_name())
                .setText(R.id.tv_appreciate_count, commentBean.getDigg_count() + "")
                .setText(R.id.tv_comment, commentBean.getText())
                .setText(R.id.tv_comment_time, TimeUtil.transformNewsPublishTime(commentBean.getCreate_time()));
        if (commentBean.getReply_count() != 0) {
            helper.setText(R.id.tv_single_comment_reply_count, commentBean.getReply_count() + MyApplication.getContext().getString(R.string.reply));
        }
        ImageLoaderUtil.
                loadCircleImage(MyApplication.getContext(), commentBean.getUser_profile_image_url(), (ImageView) helper.getView(R.id.img_user_portrait));
    }
}
