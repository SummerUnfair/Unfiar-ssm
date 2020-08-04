package com.unfair.testInterface;

import com.unfair.api.dto.UserDTO;
import com.unfair.api.vo.UserVO;
import com.unfair.service.UserService;
import com.unfair.service.RedisService;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class ServiceJunitTest {

    private static Logger LOGGER = LoggerFactory.getLogger(ServiceJunitTest.class);
    private static  ApplicationContext ac = new ClassPathXmlApplicationContext("spring-common.xml");
    RedisService redisService= null;

    private static DefaultMQProducer defaultMQProducer= (DefaultMQProducer)ac.getBean("defaultMQProducer");

    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("spring-common.xml");
        redisService = (RedisService) ac.getBean("redisService");
        defaultMQProducer=(DefaultMQProducer)ac.getBean("defaultMQProducer");
    }

    /**
     * 接口测试
     */
    @Test
    public void userServiceTest(){
        UserService user = (UserService) ac.getBean("userService");
        UserDTO userVO1 = new UserDTO();
        List<UserVO> all = user.findAll(userVO1);
        LOGGER.info("接口测试，对象数组容量:[{}]条",all.size());
        for (UserVO userVO : all) {
            System.out.println(userVO);
        }
    }

    @Test
    public void assertTest(){
        String location = null;
        Assert.notNull(location, "Location must not be null");
        System.out.println("location = [" + location + "]");
    }

    @Test
    public void redisTest(){
        redisService.set("unfair","unfair1111");
    }

    @Test
    public void rocketTemTest() throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        defaultMQProducer.start();
        for (int i = 0; i < 100; i++) {
            // Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("ferao 帅").getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            // Call send message to deliver message to one of brokers.
            SendResult sendResult = defaultMQProducer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        defaultMQProducer.shutdown();
    }

    public static void main (String[] args) throws MQClientException, UnsupportedEncodingException, RemotingException, InterruptedException, MQBrokerException {
        for (int i = 0; i < 10; i++) {
            // Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("ferao 帅").getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            // Call send message to deliver message to one of brokers.
            SendResult sendResult = defaultMQProducer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //defaultMQProducer.shutdown();
    }

}
