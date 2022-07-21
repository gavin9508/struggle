package com.struggle.design.strategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Author sly
 * @Date 2022/7/20 23:48
 * @Description 超级会员优惠方式
 */
@Service(value = "SVIP")
public class SVIP implements Buyer {

    @Override
    public String getName() {
        return "SVIP";
    }

    @Override
    public BigDecimal calPrice(BigDecimal orderPrice) {
        return orderPrice.multiply(new BigDecimal(0.8));
    }
}