package com.unfair.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unfair.api.dto.LoginInfoDTO;
import com.unfair.api.vo.UserVO;
import com.unfair.bootstrap.base.BaseController;
import com.unfair.bootstrap.request.BusinessReqMsg;
import com.unfair.service.LoginService;
import com.unfair.service.UserService;
import com.unfair.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author fenghao
 */
@Controller
@RequestMapping("/unfairHome")
public class UnfairController extends BaseController {

    @Resource
    private UserService userService;

    @Autowired
    private LoginService loginService;

    private static Logger LOGGER = LoggerFactory.getLogger(UnfairController.class);

    /**
     * RequestBody、Model测试
     *
     * @param reqMsg
     * @param model  每次请求中都存在的默认参数，利用其addAttribute()方法即可将服务器的值传递到jsp页面中，在jsp页面利${message}即可取出其中的值
     * @return 跳转对应页面
     */
    @PostMapping("/Login")
    public String login(@RequestBody BusinessReqMsg reqMsg, Model model) {
        LoginInfoDTO dto = JSON.parseObject((String) reqMsg.getData(), LoginInfoDTO.class);
        boolean isExit = loginService.checkUserInfo(dto);
        if (isExit ==true){
            model.addAttribute("weekNumber", TimeUtils.get_Now_Week_Number() - 1);
            return "redirect:SubLogin";
        }else {
            model.addAttribute("message", "查询服务结束，无用户信息!");
            return "NotExit";
        }
    }

    /**
     * @RequestParam测试
     */
    @RequestMapping(value = "/contest")
    @ResponseBody
    public String contextPathTest(@RequestParam(name = "userName", required = false, defaultValue = "unfair") Object userName,
                                  HttpServletRequest req) {
        String realPath = null;
        try {
            realPath = req.getSession().getServletContext().getRealPath("/");
            String a = "{\"id\":1,\"username\":\"男\"}";
            ObjectMapper mapper = new ObjectMapper();
            UserVO userVo = mapper.readValue(a, UserVO.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return realPath + "测试";
    }

    /**
     * RequestParam 测试
     *
     * @param name
     * @return
     */
    @RequestMapping("/testRequestParam")
    @ResponseBody
    public String testRequestParam(@RequestParam(name = "username") String name) {
        System.out.println(name);
        return "ResponseBody success";
    }

    /**
     * RequestMapping注解
     *
     * @return
     */
    @RequestMapping(value = "/sayHello", params = {"username=heihei"}, method = {RequestMethod.GET}, headers = {"Accept"})
    public String sayHello() {
        return "sayHellosuccess";
    }

}
