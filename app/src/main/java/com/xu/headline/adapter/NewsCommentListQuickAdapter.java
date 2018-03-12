package com.xu.headline.adapter;

import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.xu.headline.MyApplication;
import com.xu.headline.R;
import com.xu.headline.bean.CommentListBean;
import com.xu.headline.utils.CommentEmojiUtil;
import com.xu.headline.utils.ImageLoaderUtil;
import com.xu.headline.utils.TimeUtil;
import com.xu.headline.utils.TransformUtils;

import java.util.List;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by xusn10 on 2018/3/2.
 *
 * @author xu
 *         评论list的adapter
 */

public class NewsCommentListQuickAdapter extends BaseQuickAdapter<CommentListBean.DataBean, BaseViewHolder> {

    public NewsCommentListQuickAdapter(@Nullable List<CommentListBean.DataBean> data) {
        super(R.layout.item_news_details_comment, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentListBean.DataBean item) {
        CommentListBean.DataBean.CommentBean commentBean = item.getComment();
        helper.setText(R.id.tv_user_name, commentBean.getUser_name())
                .setText(R.id.tv_appreciate_count, commentBean.getDigg_count() + "")
                .setText(R.id.tv_comment, CommentEmojiUtil.getEmojiString(commentBean.getText()))
                .setText(R.id.tv_comment_time, TimeUtil.transformNewsPublishTime(commentBean.getCreate_time()));
        if (commentBean.getReply_count() != 0) {
            helper.getView(R.id.tv_single_comment_reply_count).setVisibility(View.VISIBLE);
            helper.getView(R.id.tv_reply).setVisibility(View.GONE);
            helper.setText(R.id.tv_single_comment_reply_count, MyApplication.getContext().getString(R.string.reply_count, commentBean.getReply_count()));
        } else {
            helper.getView(R.id.tv_single_comment_reply_count).setVisibility(View.GONE);
            helper.getView(R.id.tv_reply).setVisibility(View.VISIBLE);
        }
        ImageLoaderUtil.
                loadCircleImage(MyApplication.getContext(), commentBean.getUser_profile_image_url(), (ImageView) helper.getView(R.id.img_user_portrait));
    }
}
