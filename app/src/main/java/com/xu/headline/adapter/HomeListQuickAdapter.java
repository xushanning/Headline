package com.xu.headline.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xu.headline.R;
import com.xu.headline.adapter.entity.MultiNewsItem;
import com.xu.headline.utils.ImageLoaderUtil;
import com.xu.headline.utils.TimeUtil;

import java.util.List;

/**
 * Created by xusn10 on 2018/1/19.
 *
 * @author xu
 */

public class HomeListQuickAdapter extends BaseMultiItemQuickAdapter<MultiNewsItem, BaseViewHolder> {
    public HomeListQuickAdapter(List<MultiNewsItem> data) {
        super(data);
        addItemType(MultiNewsItem.TEXT_NEWS, R.layout.item_news_text);
        addItemType(MultiNewsItem.SINGLE_SMALL_IMG_NEWS, R.layout.item_news_single_small_img);
        addItemType(MultiNewsItem.SINGLE_LARGE_IMG_NEWS, R.layout.item_news_single_large_img);
        addItemType(MultiNewsItem.MULTI_IMG_NEWS, R.layout.item_news_multi_img);
        addItemType(MultiNewsItem.AD_NEWS, R.layout.item_news_ad);
    }


    @Override
    protected void convert(BaseViewHolder helper, MultiNewsItem item) {
        //标题
        helper.setText(R.id.tv_title, item.getItemBean().getTitle())
                .addOnClickListener(R.id.img_close);
        if (item.getItemBean().getPublish_time() != 0) {
            helper.setText(R.id.tv_time, TimeUtil.transformNewsPublishTime(item.getItemBean().getPublish_time()));
        }


        switch (item.getItemType()) {
            case MultiNewsItem.TEXT_NEWS:
                helper.setText(R.id.tv_source, item.getItemBean().getSource())
                        .setText(R.id.tv_comment_count, item.getItemBean().getComment_count() + "评论");
                break;
            case MultiNewsItem.SINGLE_SMALL_IMG_NEWS:
                if (item.getItemBean().getSource() != null) {
                    helper.setText(R.id.tv_source, item.getItemBean().getSource());
                }
                helper.setText(R.id.tv_comment_count, item.getItemBean().getComment_count() + "评论");
                ImageLoaderUtil.loadImage(mContext, item.getItemBean().getMiddle_image().getUrl(), (ImageView) helper.getView(R.id.img_small));
                break;
            case MultiNewsItem.SINGLE_LARGE_IMG_NEWS:

                break;
            case MultiNewsItem.MULTI_IMG_NEWS:
                helper.setText(R.id.tv_source, item.getItemBean().getSource())
                        .setText(R.id.tv_comment_count, item.getItemBean().getComment_count() + "评论");
                ImageLoaderUtil.loadImage(mContext, item.getItemBean().getImage_list().get(0).getUrl(), (ImageView) helper.getView(R.id.img_multi_1));
                ImageLoaderUtil.loadImage(mContext, item.getItemBean().getImage_list().get(1).getUrl(), (ImageView) helper.getView(R.id.img_multi_2));
                ImageLoaderUtil.loadImage(mContext, item.getItemBean().getImage_list().get(2).getUrl(), (ImageView) helper.getView(R.id.img_multi_3));
                break;
            case MultiNewsItem.AD_NEWS:
                break;
            default:
                break;
        }
//        helper.setText(R.id.tv_title, item.getTitle())
//                .setText(R.id.tv_source, item.getSource())
//                .setText(R.id.tv_time, item.getPubDate())
//                .addOnClickListener(R.id.img_close);
//        if (item.isHavePic()) {
//            ImageLoaderUtil.loadImage(mContext, item.getImageurls().get(0).getUrl(), (ImageView) helper.getView(R.id.img_thumbnail));
//        }
    }
}
