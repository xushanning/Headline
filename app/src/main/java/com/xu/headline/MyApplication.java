package com.xu.headline;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Created by xusn10 on 2018/1/15.
 *
 * @author xusn10
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
        context = getApplicationContext();
    }

    /**
     * 初始化logger
     */
    private void initLogger() {
        if (BuildConfig.DEBUG) {
            Logger.addLogAdapter(new AndroidLogAdapter());
        }
    }

    public static Context getContextInstance() {
        return context;
    }
}
