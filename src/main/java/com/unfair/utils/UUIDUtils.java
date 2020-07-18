package com.unfair.utils;/*
 * @author Ferao
 * @date
 * @discription
 */

import org.junit.Test;

import java.util.UUID;

@SuppressWarnings("all")
public class UUIDUtils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
