package com.xu.headline.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xu.headline.bean.response.TouTiaoNewsVideoItemBean;

import java.util.List;

/**
 * @author 言吾許
 *         视频列表adapter
 */

public class VideoListQuickAdapter extends BaseQuickAdapter<List<TouTiaoNewsVideoItemBean>, BaseViewHolder> {
    public VideoListQuickAdapter(@Nullable List<List<TouTiaoNewsVideoItemBean>> data) {
        super(data);
    }

    @Override
    protected void convert(BaseViewHolder helper, List<TouTiaoNewsVideoItemBean> item) {

    }
}
