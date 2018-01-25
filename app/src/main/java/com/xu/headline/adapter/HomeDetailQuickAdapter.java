package com.xu.headline.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.bean.IDataNewsBean;
import com.xu.headline.utils.ImageLoaderUtil;

import java.util.List;

/**
 * Created by xusn10 on 2018/1/19.
 *
 * @author xu
 */

public class HomeDetailQuickAdapter extends BaseQuickAdapter<IDataNewsBean, BaseViewHolder> {

    public HomeDetailQuickAdapter(int layoutResId, @Nullable List<IDataNewsBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, IDataNewsBean item) {
        Logger.d(item.getTitle());
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_source, item.getPosterScreenName())
                .setText(R.id.tv_time, item.getPublishDate())
                .addOnClickListener(R.id.img_close);
        ImageLoaderUtil.loadImage(mContext, item.getImageUrls().get(0), (ImageView) helper.getView(R.id.img_thumbnail));
    }
}
