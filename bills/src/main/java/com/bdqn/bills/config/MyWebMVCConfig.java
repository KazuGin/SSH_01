package com.bdqn.bills.config;

import com.bdqn.bills.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMVCConfig implements WebMvcConfigurer {


    /**
     * 注入拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/bills/**");
    }


    /**
     * 设置默认的访问页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //去到登录页面
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }


}
