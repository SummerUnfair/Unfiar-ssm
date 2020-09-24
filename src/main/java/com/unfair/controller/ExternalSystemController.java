package com.unfair.controller;

import com.alibaba.fastjson.JSON;
import com.unfair.api.dto.BusinessReqDTO;
import com.unfair.bootstrap.request.BusinessReqMsg;
import com.unfair.bootstrap.response.CommonResult;
import com.unfair.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :fenghao
 * @date:2020/09/22
 * @description:外部系统访问
 */
@RestController
public class ExternalSystemController {

    private static Logger LOGGER = LoggerFactory.getLogger(UnfairController.class);

    @Resource
    private UserService userService;

    /**
     * RequestBody、Model、枚举测试
     *
     * @param reqMsg
     * @param model
     * @return result
     */

    @PostMapping("/api/foreign/query")
    public CommonResult queryEntry(@RequestBody BusinessReqMsg reqMsg, Model model) {
        validate(reqMsg);

        LOGGER.info("用户业务开始 [{}]", JSON.toJSONString(reqMsg));
        CommonResult result;
        BusinessReqDTO dto = JSON.parseObject((String) reqMsg.getData(), BusinessReqDTO.class);
        result = (CommonResult) userService.queryEntry(dto);
        LOGGER.info("用户业务结束");
        return result;
    }

    private void validate(BusinessReqMsg reqMsg) {
        Assert.notNull(reqMsg.getActionCmd(), "业务操作名不能为空");
        Assert.notNull(reqMsg.getRequestId(), "请求流水号不能为空");
        Assert.notNull(reqMsg.getRequestDate(),"请求日期不能为空");
        Assert.notNull(reqMsg.getData(), "用户信息不能为空");
    }
}
