package com.xu.headline;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.xu.headline.db.DaoMaster;
import com.xu.headline.db.DaoSession;

/**
 * Created by xusn10 on 2018/1/15.
 *
 * @author xusn10
 */

public class MyApplication extends Application {
    private static Context context;
    private DaoSession mDaoSession;
    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initLogger();
        initDatabase();
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

    private void initDatabase() {
        DaoMaster.DevOpenHelper mHelper = new DaoMaster.DevOpenHelper(this, "TouTiao-db", null);
        SQLiteDatabase db = mHelper.getWritableDatabase();
        DaoMaster mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }


    public static MyApplication getInstance() {
        return instance;
    }

    public static Context getContext() {
        return context;
    }
}
