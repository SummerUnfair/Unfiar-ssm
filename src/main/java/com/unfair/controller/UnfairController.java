package com.unfair.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unfair.api.dto.UserDTO;
import com.unfair.api.vo.UserVO;
import com.unfair.service.UserService;
import com.unfair.utils.JacksonUtils;
import com.unfair.utils.StringUtils;
import com.unfair.utils.TimeUtils;
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
        LOGGER.info("用户[{}]登录",StringUtils.removeSign(StringUtils.toLowerCase(body)));
        return  "redirect:SubLogin";
    }

    @RequestMapping(value = "/SubLogin")
    public String json1(Model model){
        List<UserVO> userVO = userService.findAll(new UserDTO());
        LOGGER.info("查询服务结束,共[{}]条用户信息",userVO.size());
        model.addAttribute("userVO", userVO);
        model.addAttribute("weekNumber", TimeUtils.get_Now_Week_Number()-1);
        return "success";
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
        LOGGER.info("JsonStyle 转换内容:[{}]",JacksonUtils.ObjcetToJsonString(resultMap));
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
