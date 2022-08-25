package com.struggle.spring.common.config.filters;

import com.struggle.spring.modules.test.service.FilterService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "BeanTestFilter", urlPatterns = "/filterTest/testA")
public class BeanTestFilter implements Filter {

    @Autowired
    private FilterService filterService;

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        filterService.testA();
        chain.doFilter(request, response);
    }
}
