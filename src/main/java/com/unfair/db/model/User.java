package com.unfair.db.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private String id;

    private String username;

    private String sex;

    private String address;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    @Builder
    public User(String id, String username, String sex, String address, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.sex = sex;
        this.address = address;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}