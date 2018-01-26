package com.xu.headline.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;
import com.xu.headline.R;
import com.xu.headline.bean.IDataNewsBean;
import com.xu.headline.bean.NewsListBean;
import com.xu.headline.utils.ImageLoaderUtil;

import java.util.List;

/**
 * Created by xusn10 on 2018/1/19.
 *
 * @author xu
 */

public class HomeDetailQuickAdapter extends BaseQuickAdapter<NewsListBean.PagebeanBean.ContentlistBean, BaseViewHolder> {

    public HomeDetailQuickAdapter(int layoutResId, @Nullable List<NewsListBean.PagebeanBean.ContentlistBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, NewsListBean.PagebeanBean.ContentlistBean item) {
        helper.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_source, item.getSource())
                .setText(R.id.tv_time, item.getPubDate())
                .addOnClickListener(R.id.img_close);
        if (item.isHavePic()) {
            ImageLoaderUtil.loadImage(mContext, item.getImageurls().get(0).getUrl(), (ImageView) helper.getView(R.id.img_thumbnail));
        }
    }
}
