package com.xu.headline.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xu.headline.R;
import com.xu.headline.bean.response.authorinfo.OrderedInfoBean1;

import java.util.List;

/**
 * Created by xusn10 on 2018/3/2.
 *
 * @author xusn10
 */

public class NewsDetailLabelsQuickAdapter extends BaseQuickAdapter<OrderedInfoBean1, BaseViewHolder> {

    public NewsDetailLabelsQuickAdapter(@Nullable List<OrderedInfoBean1> data) {
        super(R.layout.item_news_details_label, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, OrderedInfoBean1 item) {
        helper.setText(R.id.tv_label, item.getWord());
    }
}
