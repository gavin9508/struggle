package com.struggle.spring.modules.test.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author gavin
 * @Date 2022/8/29 21:28
 */
@Component
@Slf4j
public class CronTask {

    @Scheduled(cron = "0/1 * * ? * ?")
    public void cron() {
        log.info("定时执行");
    }
}
