package com.unfair.service.impl;

import com.alibaba.fastjson.JSON;
import com.unfair.api.dto.LoginInfoDTO;
import com.unfair.service.LoginService;
import com.unfair.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @author fenghao
 * @discription 用户登陆服务
 * @create 2021-01-23 14:11
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private UserService userService;

    @Override
    public String checkUserInfo(LoginInfoDTO dto,String usernmae) {
        LOGGER.info("用户校验开始 : [{}]", JSON.toJSONString(dto));
        validate(dto);
        Boolean result = false;
        LOGGER.info("用户校验结束 : [{}],结果 : [{}]", JSON.toJSONString(dto),result);
        return "原方法返回";
    }

    private void validate(LoginInfoDTO dto) {
        //Assert.notNull(dto, "用户信息不能为空");
    }
}
