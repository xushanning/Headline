package com.xu.headline.ui.activity.newsdetail;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.response.CommentListBean;
import com.xu.headline.bean.response.NewsDetailsBean;
import com.xu.headline.bean.response.authorinfo.AuthorInfoBean;

/**
 * Created by xusn10 on 2018/1/19.
 *
 * @author xu
 */

public interface INewsDetailContract {
    interface INewsDetailView extends IBaseContract.IBaseView {
        /**
         * 加载新闻详情数据
         *
         * @param newsDetailsBean 新闻详情
         */
        void loadNewsDetailsData(NewsDetailsBean newsDetailsBean);

        /**
         * 加载作者信息：来源，头像，粉丝数量等
         *
         * @param authorInfoBean 用户信息bean
         */
        void loadAuthorInfo(AuthorInfoBean authorInfoBean);

        /**
         * 加载评论列表
         *
         * @param commentListBean 评论列表
         */
        void loadCommentList(CommentListBean commentListBean);
    }

    interface INewsDetailPresenter extends IBaseContract.IBasePresenter<INewsDetailView> {
        /**
         * 获取新闻详情
         *
         * @param newsID    新闻id
         * @param channelID 频道id
         */
        void getNewsDetailsData(long newsID, String channelID);
    }
}
