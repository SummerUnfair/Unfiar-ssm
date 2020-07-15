package com.unfair.utils;/*
 * @author Ferao
 * @date
 * @discription
 */

public class StringUtils {

    /**
     * 字符转小写
     * @param object
     * @return
     */
    public static String toLowerCase(Object object){
        return object.toString().toLowerCase();
    }

    /**
     * 去除字符中大小括号()（）
     * @param str
     * @return
     */
    public static String removeSign(String str){
        return str.replaceAll("[\\（\\(\\）\\)]", "");
    }
}
