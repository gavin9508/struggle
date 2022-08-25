package com.struggle.spring.common.config.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/filterTest/test").order(2);
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/filterTest/test").order(1);
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/filterTest/test").order(3);
    }
}
