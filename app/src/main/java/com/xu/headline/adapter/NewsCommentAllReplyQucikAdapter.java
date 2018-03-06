package com.xu.headline.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xu.headline.R;
import com.xu.headline.bean.CommentReplyListBean;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 *
 * @author xu
 *         所有评论回复的列表adapter
 */

public class NewsCommentAllReplyQucikAdapter extends BaseQuickAdapter<CommentReplyListBean.DataBeanX.DataBean, BaseViewHolder> {
    public NewsCommentAllReplyQucikAdapter(@Nullable List<CommentReplyListBean.DataBeanX.DataBean> data) {
        super(R.layout.item_news_details_comment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentReplyListBean.DataBeanX.DataBean item) {

    }
}
