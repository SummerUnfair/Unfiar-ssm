package com.unfair.api.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.unfair.bootstrap.base.BaseRequest;

/**
 * @author fenghao
 */
public class BusinessReqDTO implements BaseRequest {

    @JSONField(name = "username")
    private String username;
    @JSONField(name = "password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "BusinessReqDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
