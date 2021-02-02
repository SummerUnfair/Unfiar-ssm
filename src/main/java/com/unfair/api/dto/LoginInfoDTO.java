package com.unfair.api.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.unfair.bootstrap.base.BaseRequest;

import javax.validation.constraints.NotNull;

/**
 * @author fenghao
 * @discription
 * @create 2021-01-23 14:20
 */
public class LoginInfoDTO implements BaseRequest {

    @NotNull(message = "用户名不能为null")
    @JSONField(name = "username")
    private String username;
    @NotNull(message = "用户密码不能为null")
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
