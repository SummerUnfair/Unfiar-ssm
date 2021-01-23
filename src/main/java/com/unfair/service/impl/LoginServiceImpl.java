package com.unfair.service.impl;

import com.alibaba.fastjson.JSON;
import com.unfair.api.dto.LoginInfoDTO;
import com.unfair.bootstrap.response.CommonResult;
import com.unfair.service.LoginService;
import com.unfair.service.UserService;
import org.apache.commons.lang3.StringUtils;
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
@Service("userService")
public class LoginServiceImpl implements LoginService {

    private static Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Resource
    private UserService userService;

    @Override
    public boolean checkUserInfo(LoginInfoDTO dto) {
        LOGGER.info("用户校验开始 [{}]", JSON.toJSONString(dto));
        validate(dto);
        CommonResult resMsg = (CommonResult) userService.queryEntry(dto);
        if (!StringUtils.isEmpty(resMsg.getRespCode())) {
            return true;
        } else {
            return false;
        }
    }

    private void validate(LoginInfoDTO dto) {
        Assert.notNull(dto, "用户信息不能为空");
    }
}
