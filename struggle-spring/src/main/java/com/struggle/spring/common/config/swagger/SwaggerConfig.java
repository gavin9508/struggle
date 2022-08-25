package com.struggle.spring.common.config.swagger;

import com.struggle.spring.common.constant.AppConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * @Author gavin
 * @Date 2022/7/30 21:34
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // 设置要显示swagger的环境
    Profiles of = Profiles.of("dev", "test", "prod");
    // 判断当前是否处于该环境
    // 通过 enable() 接收此参数判断是否要显示
    boolean flag = true;


    @Bean
    public Docket testDocket(Environment environment) {
        flag = environment.acceptsProfiles(of);
        return docket("测试模块", AppConstant.BASE_PACKAGES + ".modules.test");
    }

    private Docket docket(String groupName, String packageName) {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName(groupName)
                .enable(flag) //配置是否启用Swagger，如果是false，在浏览器将无法访问
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(packageName))
                .paths(PathSelectors.any())
                .build();

    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("struggle-spring 接口文档")// 标题
                .description("欢迎查看 struggle-spring API文档")// 描述
                .termsOfServiceUrl("https://gitee.com/BuZhouDiao/struggle")// 组织链接
                .version(AppConstant.APPLICATION_VERSION)// 版本
                .build();
    }

}
