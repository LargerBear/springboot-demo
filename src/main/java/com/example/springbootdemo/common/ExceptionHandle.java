package com.example.springbootdemo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
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
