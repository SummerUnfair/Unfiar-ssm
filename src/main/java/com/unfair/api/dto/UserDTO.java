package com.unfair.api.dto;/*
 * @author Ferao
 * @date
 * @discription
 */

import com.alibaba.fastjson.annotation.JSONField;
import com.unfair.api.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @JSONField(name = "id")
    private String id;
    @JSONField(name = "username")
    private String username;
    @JSONField(name = "sex")
    private String sex;
    @JSONField(name = "address")
    private String address;
    @JSONField(name = "createTime")
    private Date createTime;
    @JSONField(name = "updateTime")
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id && Objects.equals(username, userDTO.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

}
