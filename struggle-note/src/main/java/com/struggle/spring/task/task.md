# Spring Task
Spring Task 是 Spring 提供的轻量级定时任务工具。

## 集成
### 1.添加 @EnableScheduling 

    @EnableScheduling
    public class StruggleSpringApplication {
    
        public static void main(String[] args) {
            SpringApplication.run(StruggleSpringApplication.class, args);
        }

    }

### 2.添加定时任务
    @Component
    @Slf4j
    public class CronTask {
    
        @Scheduled(cron = "0/1 * * ? * ?")
        public void cron() {
            log.info("定时执行，时间{}");
        }
    }