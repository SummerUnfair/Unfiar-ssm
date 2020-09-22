package com.unfair.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unfair.api.dto.UserDTO;
import com.unfair.api.vo.UserVO;
import com.unfair.db.model.User;
import com.unfair.enumeration.StatusEnum;
import com.unfair.service.UserService;
import com.unfair.utils.JacksonUtils;
import com.unfair.utils.StringUtils;
import com.unfair.utils.TimeUtils;
import org.springframework.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/unfairHome")
public class UnfairController {

    @Resource
    private UserService userService;

    private static Logger LOGGER = LoggerFactory.getLogger(UnfairController.class);

    /**
     * RequestBody测试
     * @param body
     * @return username=2343&password=3&money=1
     * function:RequestBody Test
     */
    @PostMapping("/Login")
    public String login(@RequestBody String body){
        //切换requestbody使用方式时启用
        Assert.notNull(body,"用户信息不能为空");
        LOGGER.info("用户[{}]登录",StringUtils.removeSign(StringUtils.toLowerCase(body)));
        return  "redirect:SubLogin";
    }

    /**
     * Model测试
     * @param model 每次请求中都存在的默认参数，利用其addAttribute()方法即可将服务器的值传递到jsp页面中，在jsp页面利${message}即可取出其中的值
     * @return
     */
    @RequestMapping(value = "/SubLogin")
    public String json1(Model model){
        List<User> users = userService.queryEntry(new UserDTO());
        if (!users.isEmpty()){
            LOGGER.info("查询服务结束,共[{}]条用户信息",users.size());
            model.addAttribute("userVO", users);
            model.addAttribute("weekNumber", TimeUtils.get_Now_Week_Number()-1);
            return "success";
        }else{
            model.addAttribute("message", "查询服务结束，无用户信息!");
            return "test";
        }
    }

    /**
     *@RequestParam测试
     */
    @RequestMapping(value = "/contest")
    @ResponseBody
    public String contextPathTest(@RequestParam(name = "userName", required = false,defaultValue = "unfair")Object userName,
                                  HttpServletRequest req)  {
        String realPath =null;
        try {
            realPath = req.getSession().getServletContext().getRealPath("/");
            String a= "{\"id\":1,\"username\":\"男\"}";
            ObjectMapper mapper = new ObjectMapper();
            UserVO userVO1 = mapper.readValue(a, UserVO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return realPath+"测试";
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
        return "sayHellosuccess" ;
    }

}
