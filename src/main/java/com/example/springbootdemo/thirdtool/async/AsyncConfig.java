package com.example.springbootdemo.thirdtool.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author LargerBear</ br>
 * date: 2021/1/5 15:06</br>
 * @since JDK 1.8
 */
//@EnableAsync
//@Configuration
public class AsyncConfig {

    @Bean
    public TaskExecutor executor(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        //核心线程数
        executor.setCorePoolSize(3);
        //最大线程数
        executor.setMaxPoolSize(20);
        //队列大小
        executor.setQueueCapacity(1000);
        //线程最大空闲时间
        executor.setKeepAliveSeconds(300);
        //指定用于新创建的线程名称的前缀。
        executor.setThreadNamePrefix("fsx-Executor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
