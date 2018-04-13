package com.xu.headline.ui.fragment.videolist;

import com.xu.headline.base.IBaseContract;
import com.xu.headline.bean.response.TouTiaoNewsVideoItemBean;
import com.xu.headline.bean.response.VideoAddressBean;

import java.util.List;

/**
 * Created by Administrator on 2018/1/18.
 *
 * @author xu
 */

public interface IVideoListContract {
    interface IVideoListView extends IBaseContract.IBaseView {
        /**
         * 加载视频列表数据
         *
         * @param itemBeans 列表数据
         */
        void loadVideoList(List<TouTiaoNewsVideoItemBean> itemBeans);

        /**
         * 加载视频播放地址
         *
         * @param videoBean 地址bean
         * @param position  播放器位置
         */
        void loadVideoAddress(VideoAddressBean.DataBean.VideoListBean.VideoBean videoBean, int position);
    }

    interface IVideoListPresenter extends IBaseContract.IBasePresenter<IVideoListView> {
        /**
         * 获取视频列表
         *
         * @param channelId   频道名称
         * @param refreshMode 刷新的方式
         */
        void getVideoList(String channelId, String refreshMode);

        /**
         * 从数据库加载视频列表
         *
         * @param channelId 频道名称
         */
        void getVideoFrDB(String channelId);

        /**
         * 获取视频播放的真实地址
         *
         * @param url      pc端地址
         * @param position 播放器位置
         */
        void getVideoAddress(String url, int position);
    }
}
