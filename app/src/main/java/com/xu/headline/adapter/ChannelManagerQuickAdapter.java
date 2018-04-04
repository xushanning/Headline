package com.xu.headline.adapter;

import android.view.View;
import android.widget.AdapterView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xu.headline.R;

import java.util.List;

/**
 * @author 言吾許
 */

public class ChannelManagerQuickAdapter extends BaseMultiItemQuickAdapter<MultiChannelManagerItem, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ChannelManagerQuickAdapter(List<MultiChannelManagerItem> data) {
        super(data);
        addItemType(MultiChannelManagerItem.TYPE_MY_CHANNEL_TITLE, R.layout.item_channel_manager_my_channel_title);
        addItemType(MultiChannelManagerItem.TYPE_MY_CHANNEL, R.layout.item_channel_manager_my_channel);
        addItemType(MultiChannelManagerItem.TYPE_RECOMMEND_CHANNEL_TITLE, R.layout.item_channel_manager_recommend_channel_title);
        addItemType(MultiChannelManagerItem.TYPE_RECOMMEND_CHANNEL, R.layout.item_channel_manager_recommend_channel);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiChannelManagerItem item) {
        switch (item.getItemType()) {
            case MultiChannelManagerItem.TYPE_MY_CHANNEL_TITLE:
                //编辑的点击事件
                helper.addOnClickListener(R.id.tv_edit);
                break;
            case MultiChannelManagerItem.TYPE_MY_CHANNEL:
                helper.setText(R.id.tv_my_channel, item.getChannelBean().getName())
                        .addOnLongClickListener(R.id.tv_my_channel)
                        .addOnClickListener(R.id.img_cancel);
                break;
            case MultiChannelManagerItem.TYPE_RECOMMEND_CHANNEL:

                break;
            default:
                break;
        }
    }
}
