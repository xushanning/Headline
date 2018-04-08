package com.xu.headline.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xu.headline.R;
import com.xu.headline.adapter.entity.MultiChannelManagerItem;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 言吾許
 */

public class ChannelManagerQuickAdapter extends BaseMultiItemQuickAdapter<MultiChannelManagerItem, BaseViewHolder> {
    /**
     * 当频道名称的长度大于4的时候，字体变小
     */
    private static final int CHANNEL_NAME_LENGTH_THRESHOLD = 4;
    private List<MultiChannelManagerItem> data;
    private List<ImageView> cancelImgList = new ArrayList<>();
    private TextView tvEdit, tvDragSort;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ChannelManagerQuickAdapter(List<MultiChannelManagerItem> data) {
        super(data);
        this.data = data;
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
                tvEdit = helper.getView(R.id.tv_edit);
                tvDragSort = helper.getView(R.id.tv_drag_sort);
                break;
            case MultiChannelManagerItem.TYPE_MY_CHANNEL:
                helper.setText(R.id.tv_my_channel, item.getChannelBean().getName())
                        .addOnLongClickListener(R.id.tv_my_channel)
                        .addOnClickListener(R.id.img_cancel);
                ImageView imageView = helper.getView(R.id.img_cancel);
                cancelImgList.add(imageView);
                break;
            case MultiChannelManagerItem.TYPE_RECOMMEND_CHANNEL:
                int channelLength = item.getChannelBean().getName().length();
                if (channelLength > CHANNEL_NAME_LENGTH_THRESHOLD) {
                    TextView channelName = helper.getView(R.id.tv_recommend_channel);
                    channelName.setTextSize(12);
                }
                helper.setText(R.id.tv_recommend_channel, item.getChannelBean().getName())
                        .addOnClickListener(R.id.tv_recommend_channel);
                break;
            default:
                break;
        }
    }

    /**
     * item移动
     *
     * @param fromPosition 开始位置
     * @param toPosition   结束位置
     */
    public void itemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(data, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(data, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    /**
     * 设置x图片是否可见和编辑
     */
    public void setCancelImgVisibility() {

        if (cancelImgList.size() != 0) {
            int visibility = cancelImgList.get(0).getVisibility();
            for (ImageView imageView : cancelImgList) {
                if (visibility == View.GONE) {
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.GONE);
                }
            }
            if (visibility == View.GONE) {
                tvEdit.setText(R.string.edit_complete);
                tvDragSort.setText(R.string.drag_sort);
            } else {
                tvEdit.setText(R.string.edit);
                tvDragSort.setText(R.string.add_channel);
            }

        }
    }
}
