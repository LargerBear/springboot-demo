package com.example.springbootdemo.thirdtool.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author LargerBear</ br>
 * date: 2021/1/8 15:46</br>
 * @since JDK 1.8
 */
@Component
@Slf4j
public class AsyncService {


    /**
     * 在业务中调用即可
     */
    @Async
    public void asyncTest() {
       log.info("异步任务触发");
    }
}
