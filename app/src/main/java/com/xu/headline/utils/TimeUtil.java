package com.xu.headline.utils;

import com.orhanobut.logger.Logger;
import com.xu.headline.MyApplication;
import com.xu.headline.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xusn10 on 2018/3/2.
 * 转换文章发布的时间工具类
 *
 * @author xu
 */

public class TimeUtil {
    /**
     * 文章发布时间在一分钟内
     */
    private static final int IN_A_MINUTE = 60;
    /**
     * 文章发布时间在一小时内
     */
    private static final int IN_A_HOUR = 3600;
    /**
     * 文章发布时间在一天内
     */
    private static final int IN_A_DAY = 86400;

    /**
     * 转换文章发布时间
     *
     * @param timeStamp 时间戳
     * @return 转换后的时间字符串
     */
    public static String transformNewsPublishTime(int timeStamp) {
        String result;
        int timeInterval = (int) (System.currentTimeMillis() / 1000) - timeStamp;
        if (timeInterval <= IN_A_MINUTE) {
            result = MyApplication.getContext().getString(R.string.time_in_a_minute);
        } else if (timeInterval > IN_A_MINUTE && timeInterval <= IN_A_HOUR) {
            result = timeInterval / 60 + MyApplication.getContext().getString(R.string.time_in_a_hour);
        } else if (timeInterval > IN_A_HOUR && timeInterval <= IN_A_DAY) {
            result = timeInterval / 3600 + MyApplication.getContext().getString(R.string.time_in_a_day);
        } else {
            SimpleDateFormat myFmt = new SimpleDateFormat("MM-dd HH:mm·");
            result = myFmt.format(new Date(timeStamp * 1000));
        }
        return result;
    }
}
