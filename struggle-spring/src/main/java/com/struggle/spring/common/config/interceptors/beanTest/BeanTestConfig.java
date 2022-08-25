package com.struggle.spring.common.config.interceptors.beanTest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BeanTestConfig implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {
        //拦截器加载的时间点在springContext之前，此时filterService为null
        registry.addInterceptor(new BeanTestInterceptor()).addPathPatterns("/filterTest/testB");
        registry.addInterceptor(getInterceptor()).addPathPatterns("/filterTest/testC");//getInterceptor()

    }

    @Bean
    public BeanTestInterceptor getInterceptor() {
        return new BeanTestInterceptor();//注入了 BeanTestInterceptor
    }
}
