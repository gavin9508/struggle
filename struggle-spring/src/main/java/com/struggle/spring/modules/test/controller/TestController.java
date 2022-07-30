package com.struggle.spring.modules.test.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

/**
 * @Author gavin
 * @Date 2022/7/30 21:39
 */
@Api(tags ="测试")
@RestController
public class TestController {

    @GetMapping("/test")
    public String hello() {
        return "hello word";
    }

}
