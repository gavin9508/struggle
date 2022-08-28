package com.struggle.spring.modules.test.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author gavin
 * @Date 2022/8/28 18:21
 */
@Data
@ApiModel(value = "用户", description = "用户对象")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private Integer age;
}
