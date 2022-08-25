package com.struggle.spring.common.config.interceptors.beanTest;

import com.struggle.spring.modules.test.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BeanTestInterceptor implements HandlerInterceptor {

    @Autowired
    private FilterService filterService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("************************ BeanTestInterceptor 前置 ************************");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) throws Exception {
        filterService.testB();
        System.out.println("************************ BeanTestInterceptor 处理中 ************************");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("************************ BeanTestInterceptor 后置 ************************");
    }
}
