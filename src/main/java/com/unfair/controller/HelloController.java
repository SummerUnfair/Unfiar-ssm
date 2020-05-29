package com.unfair.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.unfair.pojo.User;
import com.unfair.pojo.requestBodyPO;
import com.unfair.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping("/helloController")
public class HelloController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/contest")
    @ResponseBody
    public String contextPathTest(HttpServletRequest request)  {

        String realPath = request.getSession().getServletContext().getRealPath("/");

        return realPath+"测试";

    }

    @RequestMapping(value = "/json1")
    @ResponseBody
    public String json1() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User(1, "男");
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(user);
        System.out.println(str);
        return str;
    }

    @RequestMapping(value = "/json2")
    @ResponseBody
    public User json2() throws IOException {
        String a= "{\"id\":1,\"username\":\"男\"}";
        ObjectMapper mapper = new ObjectMapper();
        User user1 = mapper.readValue(a, User.class);
        return user1;
    }


    /**
     * RequestBody测试
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody requestBodyPO body){
        System.out.println(body);
        return  "success";
    }

    /**
     * RequestParam 测试
     * @param name
     * @return
     */
    @RequestMapping("/testRequestParam")
    @ResponseBody
    public String testRequestParam(@RequestParam(name="username") String name){
        System.out.println(name);
        return  "ResponseBody success";
    }

    /**
     *  RequestMapping注解
     * @return
     */
    @RequestMapping(value="/sayHello",params = {"username=heihei"},method = {RequestMethod.GET},headers = {"Accept"})
    public String sayHello(){
        System.out.println("success");
        return "sayHellosuccess" ;
    }

}
