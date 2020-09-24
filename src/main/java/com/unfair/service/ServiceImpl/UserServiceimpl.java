package com.unfair.service.ServiceImpl;

import com.unfair.aopUtils.ApiAnnotation;
import com.unfair.api.dto.UserDTO;
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

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author fenghao
 * @date 2020/8/21
 * @account 普通用户服务
 */
@Service("userService")
public class UserServiceimpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceimpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MessageProducer messageProducer;

    @PostConstruct
    public void init() {
        log.info("用户模块，初始化...");
    }

    @Override
    @ApiAnnotation(desc = "查询入口-0")
    public List<User> queryEntry_original(UserDTO userDTO) {
        UserCriteria criteria = new UserCriteria();
        messageProducer.producerMessage("TopicTest","find_All","610622199805120911","msg:success ..");
        return userMapper.selectByExample(criteria);
    }

    @Override
    @ApiAnnotation(desc = "查询入口")
    public BaseResponse queryEntry(BaseRequest request) {
        log.info("主动查询开始");

        UserCriteria criteria = new UserCriteria();
        List<User> user = userMapper.selectByExample(criteria);
        messageProducer.producerMessage("TopicTest","find_All","610622199805120911","msg:success ..");

        return CommonResult.builder()
                .respCode(StatusEnum.SUCCESS.getState())
                .respMsg(StatusEnum.SUCCESS.getDesc())
                .data(user)
                .build();
    }
}
