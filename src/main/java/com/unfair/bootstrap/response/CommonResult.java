package com.unfair.bootstrap.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.unfair.bootstrap.base.BaseResponse;
import lombok.*;

/**
 * @author fenghao
 * @date 2020/09/22 - 19:46
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class CommonResult implements BaseResponse {

    @JSONField(name = "respCode")
    private String respCode;

    @JSONField(name = "respMsg")
    private String respMsg;

    @JSONField(name = "data")
    private Object data;

    @Override
    public String getRespCode() {
        return respCode;
    }

    @Override
    public String getRespMsg() {
        return respMsg;
    }

    @Override
    public Object getData() {
        return data;
    }
}
