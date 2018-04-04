package com.xu.headline.ui.activity.channelmanager;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.jaeger.library.StatusBarUtil;
import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrConfig;
import com.r0adkll.slidr.model.SlidrPosition;
import com.xu.headline.R;
import com.xu.headline.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/4/2.
 *
 * @author xu
 */

public class ChannelManagerActivity extends BaseActivity<IChannelManagerContract.IChannelPresenter> implements IChannelManagerContract.IChannelView {
    @BindView(R.id.rv_channel_manager)
    RecyclerView rvChannelManager;

    @Override
    public int setLayoutId() {
        return R.layout.activity_channel_manager;
    }

    @Override
    public void netConnected() {

    }

    @Override
    public void netDisconnected() {

    }

    @Override
    public IChannelManagerContract.IChannelPresenter setPresenter() {
        return new ChannelManagerPresenter();
    }

    @Override
    public void initOthers() {
        StatusBarUtil.setTransparent(this);
        SlidrConfig config = new SlidrConfig.Builder()
                .position(SlidrPosition.TOP)
                .edge(true)
                .scrimStartAlpha(0f)
                .build();
        Slidr.attach(this, config);

    }

}
