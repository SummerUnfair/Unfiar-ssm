package com.unfair.utils;/*
 * @author Ferao
 * @date
 * @discription
 */

import java.util.Calendar;

public class TimeUtils {

    public static int get_Now_Week_Number(){
        Calendar cal = Calendar.getInstance();
        int TimeNumber = cal.get(Calendar.DAY_OF_WEEK);
        return TimeNumber;
    }
}
