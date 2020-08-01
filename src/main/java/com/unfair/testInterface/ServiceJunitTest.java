package com.unfair.testInterface;

import com.unfair.api.dto.UserDTO;
import com.unfair.api.vo.UserVO;
import com.unfair.service.UserService;
import com.unfair.service.RedisService;
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
    ApplicationContext ac =null;
    RedisService redisService= null;
    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("spring-common.xml");
        redisService = (RedisService) ac.getBean("redisService");
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
    public void redisTemTest(){
        redisService.set("unfair","unfair");
    }
}
