package com.xu.headline.ui.fragment.video;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.response.VideoChannelBean;

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
        void loadVideoChannel(List<VideoChannelBean> channelList);

        /**
         * 加载推荐搜索的内容
         *
         * @param suggestString 推荐搜索的内容
         */
        void loadSuggestSearch(String suggestString);
    }

    interface IVideoPresenter extends IBaseContract.IBasePresenter<IVideoView> {
        /**
         * 获取视频列表
         */
        void initVideoChannel();

        /**
         * 获取推荐搜索
         */
        void getSuggestSearch();
    }
}
