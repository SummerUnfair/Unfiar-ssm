package com.unfair.api.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import java.util.Date;
import java.util.Objects;

@Alias("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO implements  Comparable<UserVO> {

    @JSONField(name = "id")
    private Integer id;
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
        UserVO userVO = (UserVO) o;
        return id == userVO.id && Objects.equals(username, userVO.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    //重写排序的规则
    @Override
    public int compareTo(UserVO o) {
        //return 0;  //认为元素都是相同的
        //自定义比较的规则，比较两个人的年龄（this,参数User）
        //return o.getId() - this.getId();   //年龄降序
        return this.getId() - o.getId();     //年龄升序
    }
}
