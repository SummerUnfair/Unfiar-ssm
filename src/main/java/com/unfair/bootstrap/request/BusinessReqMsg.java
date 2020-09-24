package com.unfair.bootstrap.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.unfair.bootstrap.base.BaseRequest;
import lombok.Data;

/**
 * @author fenghao
 * @date 2020/09/024 - 14:03
 * 业务系统请求基础类
 */
@Data
public class BusinessReqMsg implements BaseRequest {

    /**
     * 业务操作名
     */
    @JSONField(name = "actionCmd")
    private String actionCmd;

    /**
     * 请求流水号
     */
    @JSONField(name = "requestId")
    private String requestId;

    /**
     * 请求日期yyyymmdd
     */
    @JSONField(name = "requestDate")
    private String requestDate;

    /**
     * 请求内容
     */
    @JSONField(name = "data")
    private Object data;

}
