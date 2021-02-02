package com.unfair.enumeration;

/*
 * @author Ferao
 * @date
 * @discription
 */

import com.unfair.aoputils.ApiAnnotation;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public enum StatusEnum {

    /**
     * 成功
     */
    SUCCESS("S", "处理成功"),

    /**
     * 处理中
     */
    HANDLING("U", "处理中"),

    /**
     * 失败
     */
    FAIL("F", "处理失败");

    private String state;
    private String desc;

    StatusEnum(String state, String desc) {
        this.state = state;
        this.desc = desc;
    }

    @ApiAnnotation(desc = "状态-->描述")
    public static String getDesc(String state) {
        String message = "";
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.getState().equals(state)) {
                message = statusEnum.getState();
            }
        }
        return message;
    }

    @ApiAnnotation(desc = "all")
    public static List toList() {
        List list = new ArrayList();
        for (StatusEnum statusEnum : StatusEnum.values()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("state", statusEnum.getState());
            map.put("desc", statusEnum.getDesc());
            list.add(map);
        }
        return list;
    }
}
