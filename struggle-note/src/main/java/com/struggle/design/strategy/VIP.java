package com.struggle.design.strategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author sly
 * @Date 2022/7/20 23:49
 * @Description 普通会员优惠方式
 */
@Service(value = "VIP")
public class VIP implements Buyer {

    @Override
    public String getName() {
        return "VIP";
    }

    @Override
    public BigDecimal calPrice(BigDecimal orderPrice) {
        return orderPrice.multiply(new BigDecimal(0.9));
    }
}