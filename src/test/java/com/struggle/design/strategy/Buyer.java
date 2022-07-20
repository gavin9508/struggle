package com.struggle.design.strategy;

import java.math.BigDecimal;

/**
 * @Author sly
 * @Date 2022/7/20 23:46
 * @Description 抽象策略类 -- 定义了计算价格方法
 */
public interface Buyer {
    String getName();
    BigDecimal calPrice(BigDecimal orderPrice);
}
