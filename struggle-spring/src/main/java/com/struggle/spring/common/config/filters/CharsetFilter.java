package com.struggle.spring.common.config.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @WebFilter 需要在启动类上开启@ServletComponentScan注解
 * 加上@Component 注解或@Configuration 注解后 会初始化两次，并且第二次的initParams参数获取不到，为null
 * 注：/* 匹配所有， /** 都匹配不上
 **/
@WebFilter(filterName = "CharsetFilter"
//        ,urlPatterns = "/*"/*通配符（*）表示对所有的web资源进行拦截*/
        , urlPatterns = "/filterTest/*"
        , initParams = {
        @WebInitParam(name = "charset", value = "utf-8")}/*这里可以放一些初始化的参数*/
)
public class CharsetFilter implements Filter {
    private String filterName;
    private String charset;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /*初始化方法  接收一个FilterConfig类型的参数 该参数是对Filter的一些配置*/
        filterName = filterConfig.getFilterName();
        System.out.print("************************ 过滤器 " + filterName + " 初始化 ************************ ");
        charset = filterConfig.getInitParameter("charset");
        System.out.println("字符集编码：" + charset);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*过滤方法 主要是对request和response进行一些处理，然后交给下一个过滤器或Servlet处理*/
        System.out.println("************************ " + filterName + " 处理中 ************************");
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        /*销毁时调用*/
        System.out.println("************************ " + filterName + " 销毁 ************************");
//        Filter.super.destroy();
    }
}