package com.xu.headline;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by xusn10 on 2018/1/15.
 *
 * @author xusn10
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
    }

    /**
     * 初始化logger
     */
    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter());
        }
    }
}
