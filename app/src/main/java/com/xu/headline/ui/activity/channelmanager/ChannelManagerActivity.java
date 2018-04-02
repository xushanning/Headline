package com.xu.headline.ui.activity.channelmanager;

import com.xu.headline.R;
import com.xu.headline.base.BaseActivity;

/**
 * Created by Administrator on 2018/4/2.
 *
 * @author xu
 */

public class ChannelManagerActivity extends BaseActivity<IChannelManagerContract.IChannelPresenter> implements IChannelManagerContract.IChannelView {
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
}
