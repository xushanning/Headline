package com.xu.headline.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by xusn10 on 2017/12/13.
 *
 * @author 许善宁
 *         网络状态监听的广播接受者
 */

public class NetBroadcastReceiver extends BroadcastReceiver {
    public NetworkListener networkListener;
    private ConnectivityManager connectivityManager;
    private NetworkInfo info;

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        switch (action) {
            case ConnectivityManager.CONNECTIVITY_ACTION:
                connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                info = connectivityManager.getActiveNetworkInfo();
                if (info != null && info.isAvailable()) {
                    //回调
                    networkListener.netConnected();
                } else {
                    networkListener.netDisconnected();
                }
                break;
            default:
                break;
        }

    }

    public void setOnNetworkListener(NetworkListener networkListener) {
        this.networkListener = networkListener;
    }

    public interface NetworkListener {
        /**
         * 有网
         */
        void netConnected();

        /**
         * 无网
         */
        void netDisconnected();

    }
}
