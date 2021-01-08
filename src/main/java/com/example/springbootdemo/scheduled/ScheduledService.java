package com.example.springbootdemo.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
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
