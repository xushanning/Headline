package com.xu.headline.ui.fragment.video;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.VideoChannelBean;

import java.util.List;

/**
 * @author xu
 * @date 2018/1/16
 */

public interface IVideoContract {
    interface IVideoView extends IBaseContract.IBaseView {
        /**
         * 加载视频列表
         *
         * @param channelList 频道列表
         */
        void loadVideoChannel(List<VideoChannelBean.TypesBean> channelList);
    }

    interface IVideoPresenter extends IBaseContract.IBasePresenter<IVideoView> {
        /**
         * 获取视频列表
         */
        void getVideoChannel();
    }
}
