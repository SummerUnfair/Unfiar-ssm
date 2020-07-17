package com.unfair.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.unfair.api.vo.UserVO;
import com.unfair.service.UserService;
import com.unfair.utils.StringUtils;
import com.unfair.utils.TimeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/unfairHome")
public class UnfairController {

    @Autowired
    private UserService userService;

    private static Log LOGGER = LogFactory.getLog(UnfairController.class);

    /**
     * RequestBody测试
     * @param body
     * @return username=2343&password=3&money=1
     * function:RequestBody Test
     */
    @PostMapping("/Login")
    public String login(@RequestBody String body,Model model){
        LOGGER.info("@RequestBody返回内容:"+StringUtils.removeSign(StringUtils.toLowerCase(body)));
        List<UserVO> userVO = userService.findAll();
        model.addAttribute("userVO", userVO);
        model.addAttribute("weekNumber", TimeUtils.get_Now_Week_Number()-1);
        return  "success";
    }

    /**
     *@@ResponseBody测试
     * 将数据返回给浏览器,如果是对象,转为json返回给浏览器
     */
    @GetMapping("/JsonStyle")
    @ResponseBody
    public Map jsonStyle(){
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("titile", "主题");
        resultMap.put("message", "展示简单得Json格式");
        resultMap.put("status", "success");
        return resultMap;
    }

    /**
     *@RequestParam测试
     */
    @RequestMapping(value = "/contest")
    @ResponseBody
    public String contextPathTest(@RequestParam(name = "unfair_name", required = true)Object unfair_name, HttpServletRequest request)  {
        String realPath =null;
        try {
            realPath = request.getSession().getServletContext().getRealPath("/");
            String a= "{\"id\":1,\"username\":\"男\"}";
            ObjectMapper mapper = new ObjectMapper();
            UserVO userVO1 = mapper.readValue(a, UserVO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return realPath+"测试";
    }

    @RequestMapping(value = "/json1")
    @ResponseBody
    public String json1() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        UserVO userVO = new UserVO(1, "男");
        //将我们的对象解析成为json格式
        String str = mapper.writeValueAsString(userVO);
        System.out.println(str);
        return str;
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
