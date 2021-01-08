package com.example.springbootdemo.third_tool.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
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
