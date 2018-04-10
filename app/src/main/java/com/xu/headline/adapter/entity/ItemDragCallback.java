package com.xu.headline.adapter.entity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.xu.headline.adapter.ChannelManagerQuickAdapter;

import java.util.Collections;

/**
 * @author 言吾許
 *         拖拽
 */

public class ItemDragCallback extends ItemTouchHelper.Callback {
    private ChannelManagerQuickAdapter adapter;

    public ItemDragCallback(ChannelManagerQuickAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //我的频道标题 和 频道推荐标题 推荐频道，不能移动
        if (viewHolder.getLayoutPosition() == 0 || viewHolder.getLayoutPosition() > adapter.getMyChannelCount() ) {
            return 0;
        }
        //四个方向都能拖拽
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        int swipeFlags = 0;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();
        adapter.itemMove(fromPosition, toPosition);
        adapter.setCancelImgVisibility();
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
