# MyBatis 集成

## 1. 引入pom
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>2.2.2</version>
    </dependency>

## 2. 添加mapper
    @Repository
    public interface UserMapper {
        List<User> getAllUser();
    }
## 3.新建.mapper 文件
    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
    <mapper namespace="com.struggle.spring.modules.test.mapper.UserMapper">
    
        <select id="getAllUser" resultType="com.struggle.spring.modules.test.entity.User">
            select *
            from user
        </select>
    
    </mapper>
## 4.添加扫描 
    @SpringBootApplication
    @MapperScan//扫描 mapper
    public class StruggleSpringApplication {

        public static void main(String[] args) {
            SpringApplication.run(StruggleSpringApplication.class, args);
        }
    
    }
## 5.添加yml配置
    mybatis-plus:
      mapper-locations: classpath:/mapper/*.xml