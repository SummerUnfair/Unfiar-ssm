package com.unfair.api.dto;/*
 * @author Ferao
 * @date
 * @discription
 */

import com.alibaba.fastjson.annotation.JSONField;
import com.unfair.bootstrap.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessReqDTO implements BaseRequest {

    @JSONField(name = "username")
    private String username;
    @JSONField(name = "password")
    private String password;
}
