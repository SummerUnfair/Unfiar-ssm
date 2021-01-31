package com.unfair.testInterface;

import com.unfair.api.dto.LoginInfoDTO;
import com.unfair.api.dto.UserDTO;
import com.unfair.service.LoginService;
import com.unfair.service.UserService;
import com.unfair.common.RedisService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class ServiceJunitTest {

    private static Logger LOGGER = LoggerFactory.getLogger(ServiceJunitTest.class);
    private static ApplicationContext ac;
    private static RedisService redisService;

    @Before
    public void before() {
        ac = new ClassPathXmlApplicationContext("spring-common.xml");
        redisService = (RedisService) ac.getBean("redisService");
    }

    /**
     * 接口测试
     */
    @Test
    public void userServiceTest() {
        //UserService user = (UserService) ac.getBean("userService");
        LoginService loginService = (LoginService) ac.getBean("loginService");

        loginService.checkUserInfo(new LoginInfoDTO());

//        List<User> all = user.queryEntry(userVO1);
//        if (all == null) {
//
//            System.out.println("对象为空");
//        }
//
//        LOGGER.info("接口测试，对象数组容量:[{}]条", all.size());
//        for (User userVO : all) {
//            System.out.println(userVO);
//        }
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

}
