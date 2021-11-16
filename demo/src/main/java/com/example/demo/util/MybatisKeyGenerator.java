package com.example.demo.util;

/**
 * @author lx
 * @version 1.0
 * @description: TODO
 * @date 2021/7/23 10:10
 */

import org.springframework.stereotype.Component;

/**
 * mybaits 自定义主键生成器
 */
@Component // 加入到spring容器中
public abstract class MybatisKeyGenerator  {
   // @Value("${server.worker-id:1}")
   // private Integer workerId;

    //@Value("${server.data-center-id:1}")
   // private Integer dataCenterId;

    public Number nextId(Object entity) {
        //上面的雪花算法
        long uid = new SnowFlakeUtil().snowflakeId();
        return uid;
    }
}

