package com.unfair.testInterface;

import com.unfair.api.dto.BusinessReqDTO;
import com.unfair.api.dto.UserDTO;
import com.unfair.bootstrap.base.BaseResponse;
import com.unfair.mq.producer.MessageProducer;
import com.unfair.service.UserService;
import com.unfair.common.RedisService;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import java.util.List;

public class ServiceJunitTest {

    private static Logger LOGGER = LoggerFactory.getLogger(ServiceJunitTest.class);
    private static ApplicationContext ac;
    private static RedisService redisService;
    private static DefaultMQProducer defaultMQProducer;
    private static MessageProducer messageProducer;

    @Before
    public void before() {
        ac = new ClassPathXmlApplicationContext("spring-common.xml");
        redisService = (RedisService) ac.getBean("redisService");
        defaultMQProducer = (DefaultMQProducer) ac.getBean("defaultMQProducer");
        messageProducer = (MessageProducer) ac.getBean("messageProducer");
    }

    /**
     * 接口测试
     */
    @Test
    public void userServiceTest() {
        UserService user = (UserService) ac.getBean("userService");
        UserDTO userVO1 = new UserDTO();
        if (user ==null){
            System.out.println("user对象为空");
        }
        BaseResponse baseResponse = user.queryEntry(new BusinessReqDTO());
    }

    @Test
    public void assertTest() {
        String location = null;
        Assert.notNull(location, "Location must not be null");
        System.out.println("location = [" + location + "]");
    }

    @Test
    public void redisTest() {
        redisService.set("unfair", "unfair1111");
    }

    @Test
    public void messageProducerTest() {
        messageProducer.producerMessage("TopicTest", "TagA", "unfair", "ferao 帅");
    }

}
