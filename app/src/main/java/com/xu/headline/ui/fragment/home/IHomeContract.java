package com.xu.headline.ui.fragment.home;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.ChannelBean;
import com.xu.headline.bean.ShowApiChannelListBean;

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
        void loadData(List<ShowApiChannelListBean.ChannelListBean> channelList);
    }

    interface IHomePresenter extends IBaseContract.IBasePresenter<IHomeView> {
        /**
         * 初始化频道列表
         */
        void initChannel();
    }
}
