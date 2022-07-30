# swagger2 集成

## 1.引入依赖

    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.9.2</version>
    </dependency>
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.9.2</version>
    </dependency>

## 2.编写控制器类

    @RestController
    public class TestController {
    
        @GetMapping("/test")
        public String hello() {
            return "hello word";
        }
    }

## 3.引入配置

使用 @EnableSwagger2注解指定配置

    @Configuration
    @EnableSwagger2
    public class SwaggerConfig {
    }

## 4.常用注解

| Swagger注解           | 说明                               |
|--------------|:---------------------------------|
| @Api(tags = “xxx模块说明”)  | 作用在模块类上                          |
| @ApiOperation(“xxx接口说明”)  | 作用在接口方法上                         |
| @ApiModel(“xxxPOJO说明”)      | 作用在模型类上：如VO                      |
| @ApiModelProperty(value = “xxx属性说明”,hidden = true)   | 作用在类方法和属性上，hidden设置为true可以隐藏该属性  |
| @ApiParam(“xxx参数说明”)    | 作用在参数、方法和字段上                     |

## 版本问题
Spring Boot 2.5.6 兼容Swagger 2.9.2
Spring Boot 2.6.5 兼容Swagger 3.0.0