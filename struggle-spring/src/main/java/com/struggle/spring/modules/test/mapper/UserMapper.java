package com.struggle.spring.modules.test.mapper;

import com.struggle.spring.modules.test.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author gavin
 * @Date 2022/8/28 18:25
 */
@Repository
public interface UserMapper {
    List<User> getAllUser();
}
