package com.struggle.design.strategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author sly
 * @Date 2022/7/20 23:47
 * @Description 实现类--专属会员优惠方式
 */
@Service(value = "ExclusiveVIP")
public class ExclusiveVIP implements Buyer {
    @Override
    public String getName() {
        return "ExclusiveVIP";
    }

    @Override
    public BigDecimal calPrice(BigDecimal orderPrice) {
        return orderPrice.multiply(new BigDecimal(0.7));
    }
}
