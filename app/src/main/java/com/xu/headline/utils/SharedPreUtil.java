package com.xu.headline.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.xu.headline.MyApplication;

/**
 * Created by xusn10 on 2018/2/8.
 */

public class SharedPreUtil {

    /**
     * 存放long型数据
     *
     * @param key   键
     * @param value 值
     */
    public static void putLong(String key, long value) {
        getSharedPre().edit().putLong(key, value).apply();
    }

    /**
     * 取键值对
     *
     * @param key          键（存储新闻类最后一次刷新时间的key为频道名称）
     * @param defaultValue 默认值
     * @return 值
     */
    public static long getLong(String key, long defaultValue) {
        return getSharedPre().getLong(key, defaultValue);
    }

    private static SharedPreferences getSharedPre() {
        return MyApplication.getContext().getSharedPreferences("TouTiao", Context.MODE_PRIVATE);
    }
}
