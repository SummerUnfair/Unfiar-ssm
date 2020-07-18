package com.unfair.testInterface;

import com.unfair.api.vo.UserVO;
import com.unfair.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceJunitTest {

    public static void main (String[] args)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-common.xml");
        UserService user = (UserService) ac.getBean("userServiceimpl");
        List<UserVO> all = user.findAll();
        for (UserVO userVO : all) {
            System.out.println(userVO);
        }
    }
}
