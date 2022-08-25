package com.struggle.spring.modules.test.service.impl;

import com.struggle.spring.modules.test.service.FilterService;
import org.springframework.stereotype.Service;

@Service
public class FilterServiceImpl implements FilterService {
    @Override
    public void testA() {
        System.out.println("我是测试A");
    }

    @Override
    public void testB() {
        System.out.println("我是测试B");
    }

    @Override
    public void testC() {
        System.out.println("我是测试C");
    }
}
