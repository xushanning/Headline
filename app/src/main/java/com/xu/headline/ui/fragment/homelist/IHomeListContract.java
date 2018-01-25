package com.xu.headline.ui.fragment.homelist;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.IDataNewsBean;

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
         * @param iDataNewsBeans 新闻列表实体类
         */
        void loadNewsList(List<IDataNewsBean> iDataNewsBeans);
    }

    interface IHomeListPresenter extends IBaseContract.IBasePresenter<IHomeListView> {
        /**
         * 获取新闻列表
         *
         * @param channel 频道名称
         */
        void getNewsList(String channel);

    }
}
