package com.xu.headline.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xu.headline.MyApplication;
import com.xu.headline.R;
import com.xu.headline.bean.CommentReplyListBean;
import com.xu.headline.utils.ImageLoaderUtil;
import com.xu.headline.utils.TimeUtil;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 *
 * @author xu
 *         所有评论回复的列表adapter
 */

public class NewsCommentAllReplyQuickAdapter extends BaseQuickAdapter<CommentReplyListBean.DataBeanX.DataBean, BaseViewHolder> {
    public NewsCommentAllReplyQuickAdapter(@Nullable List<CommentReplyListBean.DataBeanX.DataBean> data) {
        super(R.layout.item_news_details_comment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentReplyListBean.DataBeanX.DataBean item) {
        helper.setText(R.id.tv_user_name, item.getUser().getName())
                .setText(R.id.tv_appreciate_count, MyApplication.getContext().getString(R.string.x_only_digit, item.getDigg_count()))
                .setText(R.id.tv_comment, item.getText())
                .setText(R.id.tv_comment_time, TimeUtil.transformNewsPublishTime(item.getCreate_time()));
        ImageLoaderUtil.loadCircleImage(MyApplication.getContext(), item.getUser().getAvatar_url(), (ImageView) helper.getView(R.id.img_user_portrait));
    }
}
