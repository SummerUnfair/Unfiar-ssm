package com.unfair.bootstrap.base;


import java.io.Serializable;

/**
 * @author fenghao
 * @date 2020/09/22 - 19:48
 * 业务系统响应基础类
 */
public interface BaseResponse extends Serializable {

    String getRespCode();

    String getRespMsg();

    Object getData();
}
