package com.xu.headline.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xu.headline.R;
import com.xu.headline.bean.authorinfo.OrderedInfoBean4;

import java.util.List;

/**
 * Created by xusn10 on 2018/3/5.
 *
 * @author xusn10
 *         推荐adapter
 */

public class RecommendQuickAdapter extends BaseQuickAdapter<OrderedInfoBean4, BaseViewHolder> {


    public RecommendQuickAdapter(@Nullable List<OrderedInfoBean4> data) {
        super(R.layout.item_news_details_recommend, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, OrderedInfoBean4 item) {
        helper.setText(R.id.tv_recommend_news, item.getTitle());
        //最后一条的下划线隐藏掉
        if (getItemCount() - 1 == helper.getLayoutPosition()) {
            helper.getView(R.id.v_segment_line).setVisibility(View.INVISIBLE);
        }
    }
}
