package com.xu.headline.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xu.headline.R;

import java.util.List;

/**
 * Created by xusn10 on 2018/1/19.
 *
 * @author xu
 */

public class HomeDetailQuickAdapter extends BaseMultiItemQuickAdapter<MultiNewsItem, BaseViewHolder> {

    public HomeDetailQuickAdapter(List<MultiNewsItem> data) {
        super(data);
        addItemType(MultiNewsItem.TEXT_NEWS, R.layout.item_news_text);
        addItemType(MultiNewsItem.SINGLE_SMALL_IMG_NEWS, R.layout.item_news_single_small_img);
        addItemType(MultiNewsItem.SINGLE_LARGE_IMG_NEWS, R.layout.item_news_single_large_img);
        addItemType(MultiNewsItem.MULTI_IMG_NEWS, R.layout.item_news_multi_img);
        addItemType(MultiNewsItem.AD_NEWS, R.layout.item_news_ad);
    }


    @Override
    protected void convert(BaseViewHolder helper, MultiNewsItem item) {
        switch (item.getItemType()) {
            case MultiNewsItem.TEXT_NEWS:
                item.getItemBean();
                break;
            case MultiNewsItem.SINGLE_SMALL_IMG_NEWS:

                break;
            case MultiNewsItem.SINGLE_LARGE_IMG_NEWS:

                break;
            case MultiNewsItem.MULTI_IMG_NEWS:

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
