package com.bdqn.bills.controller;


import com.alibaba.fastjson.JSON;
import com.bdqn.bills.entity.User;
import com.bdqn.bills.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 梁和营
 * @since 2020-04-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 登录
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/login")
    public String login(User user, HttpSession session){
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //查询用户信息
            User loginUser = userService.login(user);
            //对象不为空
            if(loginUser!=null){
                session.setAttribute("loginUser",loginUser);
                map.put("success",true);//登录成功
            }else{
                map.put("success",false);//登录失败
                map.put("message","用户名密码错误，登录失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JSON.toJSONString(map);
    }

}

