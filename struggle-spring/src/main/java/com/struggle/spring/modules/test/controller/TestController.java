package com.struggle.spring.modules.test.controller;

import com.struggle.spring.modules.test.entity.User;
import com.struggle.spring.modules.test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author gavin
 * @Date 2022/7/30 21:39
 */
@Api(tags = "测试")
@RestController
@AllArgsConstructor
public class TestController {

    private UserService userService;

    @GetMapping("/test")
    public String hello() {
        return "hello word";
    }

    @GetMapping("/getAllUser")
    @ApiOperation(value = "获取全部用户", notes = "获取全部用户")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }
}
