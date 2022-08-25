package com.struggle.spring.modules.test.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "过滤器拦截器测试")
@RequestMapping("/filterTest")
@RestController
public class FilterController {

    @GetMapping("/test")
    public String test() {
        return "这是一个测试";
    }

    @GetMapping("/testA")
    public String testA() {
        return "这是一个测试A";
    }

    @GetMapping("/testB")
    public String testB() {
        return "这是一个测试B";
    }

    @GetMapping("/testC")
    public String testC() {
        return "这是一个测试C";
    }

}
