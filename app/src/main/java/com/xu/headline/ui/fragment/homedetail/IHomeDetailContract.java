package com.xu.headline.ui.fragment.homedetail;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.NewsListBean;

/**
 * Created by xusn10 on 2018/1/18.
 *
 * @author xu
 */

public interface IHomeDetailContract {
    interface IHomeDetailView extends IBaseContract.IBaseView {
        /**
         * 加载新闻列表
         *
         * @param newsListBean 新闻列表实体类
         */
        void loadNewsList(NewsListBean newsListBean);
    }

    interface IHomeDetailPresenter extends IBaseContract.IBasePresenter<IHomeDetailView> {
        /**
         * 获取新闻列表
         *
         * @param channel 频道名称
         */
        void getNewsList(String channel);

    }
}
