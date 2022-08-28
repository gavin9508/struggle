package com.struggle.spring.modules.test.service;

import com.struggle.spring.modules.test.entity.User;

import java.util.List;

/**
 * @Author gavin
 * @Date 2022/8/28 18:27
 */
public interface UserService {

    /**
     * 获取所有用户
     *
     * @return
     */
    List<User> getAllUser();
}
