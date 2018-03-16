package com.xu.headline.base;

import android.view.View;

import com.xu.headline.receiver.NetBroadcastReceiver;

/**
 * Created by xusn10 on 2018/1/16.
 *
 * @author xusn10
 */

public interface IBase extends NetBroadcastReceiver.NetworkListener {
    /**
     * 设置layout
     *
     * @return 布局id
     */
    int setLayoutId();
}
