package com.xu.headline.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.bean.response.TouTiaoNewsVideoItemBean;
import com.xu.headline.bean.response.VideoAddressBean;
import com.xu.headline.ui.fragment.videolist.IVideoListContract;
import com.xu.headline.view.HeadLineVideoPlayer;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayer;

/**
 * @author 言吾許
 *         视频列表adapter
 */

public class VideoListQuickAdapter extends BaseQuickAdapter<TouTiaoNewsVideoItemBean, BaseViewHolder> {
    private IVideoListContract.IVideoListPresenter mPresenter;
    private List<HeadLineVideoPlayer> headLineVideoPlayers = new ArrayList<>(getItemCount());

    public VideoListQuickAdapter(@Nullable List<TouTiaoNewsVideoItemBean> data, IVideoListContract.IVideoListPresenter mPresenter) {
        super(R.layout.item_video, data);
        this.mPresenter = mPresenter;
    }

    @Override
    protected void convert(final BaseViewHolder helper, final TouTiaoNewsVideoItemBean item) {
        helper.addOnClickListener(R.id.video_player);
        HeadLineVideoPlayer videoPlayer = helper.getView(R.id.video_player);
        headLineVideoPlayers.add(videoPlayer);
        videoPlayer.setAllControlsVisiblity(View.GONE, View.GONE, View.VISIBLE, View.GONE, View.VISIBLE, View.VISIBLE, View.GONE);
        videoPlayer.setUp(null, JZVideoPlayer.SCREEN_WINDOW_LIST, item.getTitle());
        videoPlayer.setOnStartClickListener(new HeadLineVideoPlayer.OnStartClickListener() {
            @Override
            public void onStartClick() {
                Logger.d("点击开始");
                mPresenter.getVideoAddress(item.getShare_url(), helper.getLayoutPosition());
            }
        });
        // ImageLoaderUtil.loadImage(mContext);
    }

    public void setVideoAddress(VideoAddressBean.DataBean.VideoListBean.VideoBean videoBean, int position) {
        HeadLineVideoPlayer videoPlayer = headLineVideoPlayers.get(position);
        videoPlayer.setUp(videoBean.getMain_url(), JZVideoPlayer.SCREEN_WINDOW_LIST, "aaaa");
        videoPlayer.startVideo();
    }
}
