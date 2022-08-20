package com.struggle.spring.common.config.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author gavin
 * @version 1.0
 * @date 2022/8/19 下午4:10
 * @Description Druid数据源配置
 */
@Configuration
public class DruidConfig {

    /**
     * 将自定义的 Druid数据源添加到容器中
     *
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


    /**
     * 加入后台监控
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> servletRegistration = new ServletRegistrationBean<>();
        servletRegistration.setServlet(new StatViewServlet());
        //添加映射
        servletRegistration.addUrlMappings("/druid/*");
        //设置用户名密码
        servletRegistration.addInitParameter("loginUsername", "struggle");
        servletRegistration.addInitParameter("loginPassword", "struggle");
        //ip白名单（多个ip用逗号,隔开），空值代表允许所有人访问
        servletRegistration.addInitParameter("allow", "");
        //ip黑名单，优先黑名单生效
        //servletRegistration.addInitParameter("deny", "");
        //禁用HTML页面的Reset按钮
        servletRegistration.addInitParameter("resetEnable", "false");
        return servletRegistration;
    }

    /**
     * 后台监控的过滤器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        //设置一个阿里巴巴的过滤器
        filterRegistration.setFilter(new WebStatFilter());
        filterRegistration.addUrlPatterns("/*");
        //把不需要监控的过滤掉,这些不进行统计
        filterRegistration.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        filterRegistration.addInitParameter("profileEnable", "true");
        return filterRegistration;
    }

}
