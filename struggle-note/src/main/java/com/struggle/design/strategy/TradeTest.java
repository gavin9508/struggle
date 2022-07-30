package com.struggle.design.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @Author sly
 * @Date 2022/7/20 23:59
 * @Description 策略模式测试类
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TradeTest {

    @Autowired
    private BuyerHandler buyerHandler;

    @Test
    public void test() {
        BigDecimal svip = buyerHandler.getBuyer("SVIP", BigDecimal.valueOf(100));
        System.out.println(svip);
        BigDecimal vip = buyerHandler.getBuyer("VIP", BigDecimal.valueOf(100));
        System.out.println(vip);
        BigDecimal exclusiveVIP = buyerHandler.getBuyer("ExclusiveVIP", BigDecimal.valueOf(100));
        System.out.println(exclusiveVIP);
    }
}
