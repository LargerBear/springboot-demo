package com.example.springbootdemo.thirdtool.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 *
 * @author LargerBear</ br>
 * date: 2021/1/7 16:19</br>
 * @since JDK 1.8
 */
@Component
@Slf4j
public class ScheduledService {

    /**
     * springboot集成Scheduled需要在启动类上面开启监听   @EnableScheduling
     *
     * 测试为每1分钟执行一次
     */
    @Scheduled(cron = "0 0/1 * * * ?")
    public void scheduledSendMsg(){

        log.info("执行了一次"+ new Date().toString());

    }
}
