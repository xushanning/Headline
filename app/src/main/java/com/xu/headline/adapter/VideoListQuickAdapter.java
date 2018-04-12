package com.xu.headline.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.bean.response.TouTiaoNewsVideoItemBean;
import com.xu.headline.utils.ImageLoaderUtil;

import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * @author 言吾許
 *         视频列表adapter
 */

public class VideoListQuickAdapter extends BaseQuickAdapter<TouTiaoNewsVideoItemBean, BaseViewHolder> {
    public VideoListQuickAdapter(@Nullable List<TouTiaoNewsVideoItemBean> data) {
        super(R.layout.item_video, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TouTiaoNewsVideoItemBean item) {
        helper.addOnClickListener(R.id.video_player);
        JZVideoPlayerStandard jzVideoPlayer = helper.getView(R.id.video_player);
        jzVideoPlayer.setUp("http://v1-tt.ixigua.com/b296ed29673544ec168181d1ea8e1b8e/5acecc2c/video/m/220901ffd287220487284ba91e51c34fb191153d1510000aa48bb95851b/", JZVideoPlayer.SCREEN_WINDOW_LIST, item.getTitle());
        // ImageLoaderUtil.loadImage(mContext);
    }
}
