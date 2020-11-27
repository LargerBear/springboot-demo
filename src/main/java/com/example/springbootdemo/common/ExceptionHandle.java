package com.example.springbootdemo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2020/11/25 11:00</br>
 * @since JDK 1.8
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public void handle(Exception e){
        //全局异常处理

        //如果需要处理指定异常，则如下
        if (e instanceof RuntimeException){
            log.info("【this is runtime exception】{}", e);
        }else {
            log.error("【this is other exception】{}", e);
        }
    }

}
