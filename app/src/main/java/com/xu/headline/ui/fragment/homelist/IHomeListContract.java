package com.xu.headline.ui.fragment.homelist;

import com.xu.headline.adapter.entity.MultiNewsItem;
import com.xu.headline.base.IBaseContract;

import java.util.List;

/**
 * Created by xusn10 on 2018/1/18.
 *
 * @author xu
 */

public interface IHomeListContract {
    interface IHomeListView extends IBaseContract.IBaseView {
        /**
         * 加载新闻列表
         *
         * @param itemBeans 新闻列表
         */
        void loadNewsList(List<MultiNewsItem> itemBeans);

        /**
         * 从本地数据库加载数据新闻列表
         *
         * @param itemBeans 新闻列表
         */
        void loadHistoryNewsFrDb(List<MultiNewsItem> itemBeans);
    }

    interface IHomeListPresenter extends IBaseContract.IBasePresenter<IHomeListView> {
        /**
         * 获取新闻列表
         *
         * @param channel 频道名称
         */
        void getNewsList(String channel);

        /**
         * 从本地数据库里加载新闻列表
         *
         * @param channelID 频道名称
         */
        void getNewsFrDB(String channelID);

    }
}
