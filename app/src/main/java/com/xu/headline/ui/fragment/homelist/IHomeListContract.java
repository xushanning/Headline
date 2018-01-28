package com.xu.headline.ui.fragment.homelist;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.NewsListBean;

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
         * @param newsListBean 新闻列表实体类
         */
        void loadNewsList(NewsListBean newsListBean);

        /**
         * 加载更多
         *
         * @param newsListBean 频道列表
         */
        void loadMoreData(NewsListBean newsListBean);
    }

    interface IHomeListPresenter extends IBaseContract.IBasePresenter<IHomeListView> {
        /**
         * 获取新闻列表
         *
         * @param channel 频道名称
         * @param page    加载第几页
         */
        void getNewsList(String channel, int page);

    }
}
