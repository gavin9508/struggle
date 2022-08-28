package com.struggle.spring.modules.test.service.impl;

import com.struggle.spring.modules.test.entity.User;
import com.struggle.spring.modules.test.mapper.UserMapper;
import com.struggle.spring.modules.test.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author gavin
 * @Date 2022/8/28 18:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
}
