package com.struggle.design.strategy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author sly
 * @Date 2022/7/20 23:53
 * @Description 类略模式处理类
 */
@Component
public class BuyerHandler implements ApplicationContextAware, InitializingBean {

    //初始化容器后用来装我们具体实现类的一个map
    private final Map<String, Buyer> handlerMap = new ConcurrentHashMap<>();

    //spring容器的核心对象,就是用来装对象和初始化对象的
    private ApplicationContext applicationContext;

    /**
     * 重写初始化完成之后把医保的实现类都存到MAP里,键为类型,值为具体的实现对象
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansOfType(Buyer.class).forEach((k,v)->{
            if(v.getName() == null){
                return;
            }
            handlerMap.put(v.getName(),v);
        });
    }

    /**
     * 重写给applicationContext初始化赋值
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 具体的根据类型调用具体的医保实现类
     */
    public BigDecimal getBuyer(String type, BigDecimal orderPrice){
        return handlerMap.get(type).calPrice(orderPrice);
    }
}
