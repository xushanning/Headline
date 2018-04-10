package com.xu.headline.adapter.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.xu.headline.bean.response.NewsChannelListBean;

/**
 * @author 言吾許
 *         频道管理
 */

public class MultiChannelManagerItem implements MultiItemEntity {
    /**
     * 我的频道 标题
     */
    public static final int TYPE_MY_CHANNEL_TITLE = 1;
    /**
     * 我的频道
     */
    public static final int TYPE_MY_CHANNEL = 2;
    /**
     * 频道推荐 标题
     */
    public static final int TYPE_RECOMMEND_CHANNEL_TITLE = 3;
    /**
     * 频道推荐
     */
    public static final int TYPE_RECOMMEND_CHANNEL = 4;

    private int itemType;
    private int spanSize;
    private NewsChannelListBean.ChannelBean channelBean;

    public MultiChannelManagerItem(int itemType) {
        this.itemType = itemType;
    }

    public int getSpanSize() {
        return spanSize;
    }

    public void setSpanSize(int spanSize) {
        this.spanSize = spanSize;
    }

    public NewsChannelListBean.ChannelBean getChannelBean() {
        return channelBean;
    }

    public void setChannelBean(NewsChannelListBean.ChannelBean channelBean) {
        this.channelBean = channelBean;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
