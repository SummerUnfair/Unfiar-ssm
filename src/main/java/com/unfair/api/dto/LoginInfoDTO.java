package com.unfair.api.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.unfair.bootstrap.base.BaseRequest;

/**
 * @author fenghao
 * @discription
 * @create 2021-01-23 14:20
 */
public class LoginInfoDTO implements BaseRequest {

    @JSONField(name = "username")
    private String username;
    @JSONField(name = "password")
    private String password;

    public LoginInfoDTO() {
    }

    public LoginInfoDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

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
        return "LoginInfoDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
