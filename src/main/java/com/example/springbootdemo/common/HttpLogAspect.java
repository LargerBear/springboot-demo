package com.example.springbootdemo.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2020/11/25 10:11</br>
 * @since JDK 1.8
 */
@Aspect
@Component
@Slf4j
public class HttpLogAspect {


    ThreadLocal<Long> startTime = new ThreadLocal<>();
    /**
     * 拦截所有的controller，打印请求信息和过程
     */


    /**
     * 1）execution(* *(..))
     * //表示匹配所有方法
     * 2）execution(public * com. savage.service.UserService.*(..))
     * //表示匹配com.savage.server.UserService中所有的公有方法
     * 3）execution(* com.savage.server..*.*(..))
     * //表示匹配com.savage.server包及其子包下的所有方法
     */
    @Pointcut("execution(* com.example.springbootdemo.controller..*.*(..))")
    public void log(){

    }


    /**
     * 记录请求的路径等信息
     * @param joinPoint
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        // 接收到请求，记录请求内容

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();


        // 记录下请求内容

        log.info("url={}", request.getRequestURL());

        log.info("method={}", request.getMethod());

        log.info("ip={}", request.getRemoteAddr());

        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        log.info("args={}", joinPoint.getArgs());


        //获取所有参数方法
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {

            String paraName = enu.nextElement();

            System.out.println(paraName + ": " + request.getParameter(paraName));

        }
        startTime.set(System.currentTimeMillis());
    }


    @After("log()")
    public void doAfter(){

        log.info("请求结束");
    }


    /**
     * 请求完成后，记录请求耗时
     * @param object
     */
    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object)
    {
        if (null == object) {
            log.info("response={}", "空");
        } else {
            log.info("response={}", object.toString());
        }

        log.info("WebLogAspect.doAfterReturning()");

        log.info("请求耗时（毫秒） : " + (System.currentTimeMillis() - startTime.get()));

    }

}
