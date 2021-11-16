package com.example.demo.util;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author lx
 * @version 1.0
 * @description: TODO
 * @date 2021/7/23 10:03
 */
@Component
public class SnowFlakeUtil {
    private long workerId=0L;
    private long datacenterId=1L;

    private Snowflake snowflake=IdUtil.getSnowflake(workerId,datacenterId);
    @PostConstruct
    public void init(){
        try{
            workerId=NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        }catch(Exception e){
            workerId= NetUtil.getLocalhostStr().hashCode();
        }

    }

    public synchronized long snowflakeId(long workerId,long datacenterId){
        Snowflake snowflake= IdUtil.getSnowflake(workerId, datacenterId);
        return snowflake.nextId();
    }
    public synchronized long snowflakeId(){
        return snowflake.nextId();
    }

    public static void main(String[] args){
        SnowFlakeUtil snowFlakeUtil  = new SnowFlakeUtil();


       System.out.println(snowFlakeUtil.snowflakeId());
    }
}
