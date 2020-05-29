package com.unfair.testInterface;

import com.unfair.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceJunitTest {

    public static void main (String[] args)
    {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring/bean.xml");
        UserService user = (UserService) ac.getBean("userServiceimpl");
        user.findAll();
    }
}
