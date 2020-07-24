package com.unfair.testInterface;

import com.unfair.api.dto.UserDTO;
import com.unfair.api.vo.UserVO;
import com.unfair.controller.UnfairController;
import com.unfair.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import java.util.List;

public class ServiceJunitTest {
    private static Logger LOGGER = LoggerFactory.getLogger(ServiceJunitTest.class);
    /**
     * 接口测试
     */
    @Test
    public void userServiceTest(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-common.xml");
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
}
