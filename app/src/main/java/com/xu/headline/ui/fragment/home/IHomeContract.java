package com.xu.headline.ui.fragment.home;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.NewsChannelListBean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/16.
 *
 * @author xu
 */

public interface IHomeContract {
    interface IHomeView extends IBaseContract.IBaseView {
        /**
         * 加载数据
         *
         * @param channelList 频道列表
         */
        void loadData(List<NewsChannelListBean.ChannelBean> channelList);

        /**
         * 加载推荐搜索的内容
         *
         * @param suggestString 推荐搜索的内容
         */
        void loadSuggestSearch(String suggestString);
    }

    interface IHomePresenter extends IBaseContract.IBasePresenter<IHomeView> {
        /**
         * 初始化频道列表
         */
        void initChannel();

        /**
         * 获取推荐搜索
         */
        void getSuggestSearch();
    }
}
