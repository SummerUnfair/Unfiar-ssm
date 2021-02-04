package com.unfair.service.impl;

import com.unfair.annotation.ApiAnnotation;
import com.unfair.bootstrap.base.BaseRequest;
import com.unfair.bootstrap.base.BaseResponse;
import com.unfair.db.dao.UserMapper;
import com.unfair.db.model.User;
import com.unfair.db.model.UserCriteria;
import com.unfair.enumeration.StatusEnum;
import com.unfair.mq.producer.MessageProducer;
import com.unfair.bootstrap.response.CommonResult;
import com.unfair.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author fenghao
 * @date 2020/8/21
 * @account 普通用户服务
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MessageProducer messageProducer;

    @PostConstruct
    public void init() {
        log.info("用户模块，初始化...");
    }

    @Override
    @ApiAnnotation(desc = "查询入口")
    @Transactional(rollbackFor = RuntimeException.class)
    public BaseResponse queryEntry(BaseRequest request) {
        log.info("主动查询开始");

        UserCriteria criteria = new UserCriteria();
        criteria.setOrderByClause("updateTime DESC");
        List<User> user = userMapper.selectByExample(criteria);
        messageProducer.producerMessage("TopicTest","find_All","610622199805120911","msg:success ..");

        if (CollectionUtils.isEmpty(user)) {
            return null;
        }

        return CommonResult.builder()
                .respCode(StatusEnum.SUCCESS.getState())
                .respMsg(StatusEnum.SUCCESS.getDesc())
                .data(user.get(0))
                .build();
    }
}
