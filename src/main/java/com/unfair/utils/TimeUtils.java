package com.unfair.utils;/*
 * @author Ferao
 * @date
 * @discription
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间计算工具类
 * @author ThinkGem
 * @version 2013-11-03
 */
public class TimeUtils {


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * 当天处于本周第[{}]天
     * @return
     */
    public static int get_Now_Week_Number(){
        Calendar cal = Calendar.getInstance();
        int TimeNumber = cal.get(Calendar.DAY_OF_WEEK);
        return TimeNumber;
    }

    /**
     * 获取下月时间
     * @form yyyy-MM-dd
     * @return 2020-09-24 -> 2020-10-24
     */
    public static String getNextMonth(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH,1);
        Date date= calendar.getTime();
        return sdf.format(date);
    }

    /**
     * 获取明天时间
     * @form yyyy-MM-dd
     * @return 2020-09-24 -> 2020-09-25
     */
    public static String getNextDay(){

        Calendar calendar = Calendar.getInstance();
        calendar.add(calendar.DATE,1);
        Date date = calendar.getTime();
        return sdf.format(date);
    }
}
