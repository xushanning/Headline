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
 *         热门评论的adapter
 */

public class NewsCommentHotReplyQucikAdapter extends BaseQuickAdapter<CommentReplyListBean.DataBeanX.HotCommentsBean, BaseViewHolder> {
    public NewsCommentHotReplyQucikAdapter(@Nullable List<CommentReplyListBean.DataBeanX.HotCommentsBean> data) {
        super(R.layout.item_news_details_comment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentReplyListBean.DataBeanX.HotCommentsBean item) {

    }
}
