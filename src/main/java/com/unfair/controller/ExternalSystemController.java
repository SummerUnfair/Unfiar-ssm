package com.unfair.controller;

import com.unfair.enumeration.StatusEnum;
import com.unfair.response.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author :fenghao
 * @date:2020/09/22
 * @description:外部系统访问
 */
@RestController
public class ExternalSystemController {

    private static Logger LOGGER = LoggerFactory.getLogger(UnfairController.class);

    /**
     * @@ResponseBody测试
     * @@枚举 将数据返回给浏览器, 如果是对象, 转为json返回给浏览器，项目中用于传递json数据个上游系统
     */
    @GetMapping("/api/foreign/query")
    public CommonResult queryEntry() {

        return CommonResult.builder()
                .respCode(StatusEnum.SUCCESS.getState())
                .respMsg(StatusEnum.SUCCESS.getDesc())
                .data("展示简单得Json格式")
                .build();
    }
}
