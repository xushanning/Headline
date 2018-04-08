package com.xu.headline.ui.activity.channelmanager;

import com.xu.headline.adapter.entity.MultiChannelManagerItem;
import com.xu.headline.base.IBaseContract;

import java.util.List;

/**
 * Created by Administrator on 2018/4/2.
 *
 * @author xu
 */

public interface IChannelManagerContract {

    interface IChannelView extends IBaseContract.IBaseView {
        /**
         * 加载频道信息
         *
         * @param multiChannelManagerItems 频道信息items
         */
        void loadChannels(List<MultiChannelManagerItem> multiChannelManagerItems);
    }

    interface IChannelPresenter extends IBaseContract.IBasePresenter<IChannelView> {
        /**
         * 获取推荐频道列表
         */
        void getRecommendChannelList();
    }
}
