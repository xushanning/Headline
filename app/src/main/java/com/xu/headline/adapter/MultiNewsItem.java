package com.xu.headline.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by xusn10 on 2018/2/7.
 *
 * @author xu
 */

public class MultiNewsItem implements MultiItemEntity {
    /**
     * 纯文本item
     */
    public static final int TEXT_NEWS = 1;
    /**
     * 一张小图（右侧）
     */
    public static final int SINGLE_SMALL_IMG_NEWS = 2;
    /**
     * 一张大图（下方）
     */
    public static final int SINGLE_LARGE_IMG_NEWS = 3;
    /**
     * 三张图片（下方）
     */
    public static final int MULTI_IMG_NEWS = 4;
    /**
     * 广告
     */
    public static final int AD_NEWS = 5;
    private int itemType;

    public MultiNewsItem(int itemType) {
        this.itemType = itemType;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
