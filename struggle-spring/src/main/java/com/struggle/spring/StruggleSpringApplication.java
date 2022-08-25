package com.struggle.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan//Servlet、Filter、Listener可以直接通过@WebServlet、@WebFilter、@WebListener注解自动注册，无需其他代码
public class StruggleSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(StruggleSpringApplication.class, args);
    }

}
