package com.unfair.testInterface;

import com.unfair.api.dto.LoginInfoDTO;
import com.unfair.service.LoginService;
import com.unfair.common.RedisService;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Iterator;
import java.util.Set;

public class ServiceJunitTest {

    private static Logger LOGGER = LoggerFactory.getLogger(ServiceJunitTest.class);
    private static ApplicationContext ac;
    private static RedisService redisService;

    @Before
    public void before() {
        ac   = new ClassPathXmlApplicationContext("spring-common.xml");
        redisService = (RedisService) ac.getBean("redisService");
    }

    /**
     * AOP面向切面测试
     */
    @Test
    public void userServiceTest() {
        LoginService loginService = (LoginService) ac.getBean("loginService");
        //LoginInfoDTO loginInfoDTO =null;
        //String b = loginService.checkUserInfo(loginInfoDTO);
        String b = loginService.checkUserInfo(new LoginInfoDTO("username", "password"),"unfair");
        System.out.println("接口测试 :" + b);
    }

    /**
     * validation数据校验测试
     */
    @Test
    public void validationTest() {

        LoginInfoDTO loginInfoDTO = new LoginInfoDTO();
        dataDEO dataDEO = new dataDEO();
        dataDEO.setData(loginInfoDTO);
        Set result = Validation.buildDefaultValidatorFactory().getValidator().validate(dataDEO.getData(),new Class[0]);

        System.out.println(result);
        System.out.println("==========================");

        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            ConstraintViolation violation = (ConstraintViolation)iterator.next();
            System.out.println(violation.getPropertyPath().toString()+" =="+violation.getMessage());
        }
        // 对结果进行遍历输出
//        result.stream().map(v -> v.getPropertyPath() + " " + v.getMessage() )
//                .forEach(System.out::println);

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
class dataDEO {

    Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
