package com.github.cf.baselibrary.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：Chengfu on 2016/12/30 10:31
 * 邮箱：
 */
public class DateUtil {
    /**
     * 获取当前时间
     * @param timeFormat  "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getTime(String timeFormat) {
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        return format.format(new Date());
    }

    /**
     * 获取当前时间毫秒值
     * @return
     */
    public static long getCurrentTime() {
        return new Date().getTime();
    }

    /**
     * 获取指定时间
     * @param time
     * @return
     */
    public static String getTime(long time, String timeFormat) {
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        return format.format(new Date(time));
    }
    /**
     * 将时间String转换成long
     * @param strTime
     * @return
     */
    public static long timeToLong(String strTime, String timeFormat) {
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        long longTime = 0;
        try {
            longTime = format.parse(strTime).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return longTime;
    }

    public static String $(String n) {
        return Integer.valueOf(n) < 10 ? "0" + n : String.valueOf(n);
    }
    public static String $(long n) {
        return n < 10 ? "0" + n : String.valueOf(n);
    }

    public static String getTimeFromInt(long time) {
        if (time <= 0) { return "已结束"; }
        long day = time / (1 * 60 * 60 * 24);
        long hour = time / (1 * 60 * 60) % 24;
        long minute = time / (1 * 60) % 60;
        long second = time / (1) % 60;
        return "还剩：" + day + "天" + hour + "小时" + minute + "分" + second + "秒";
    }


    public static String[] getTimesFromLong(long time) {

        long day = time / (1 * 60 * 60 * 24);
        long hour = time / (1 * 60 * 60) % 24;
        long minute = time / (1 * 60) % 60;
        long second = time / (1) % 60;

        return  new String[]{$(day), $(hour), $(minute), $(second)};
    }
}
