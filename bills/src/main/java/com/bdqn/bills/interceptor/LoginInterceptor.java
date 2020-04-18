package com.bdqn.bills.interceptor;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录验证拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //session不为空，表示用户已登录，session为空表示未登录
        if(request.getSession().getAttribute("loginUser")==null){
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;//未登录
        }
        return true;//验证通过
    }
}
