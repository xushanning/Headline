package com.xu.headline.ui.activity.newsdetail;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.NewsDetailsBean;

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
