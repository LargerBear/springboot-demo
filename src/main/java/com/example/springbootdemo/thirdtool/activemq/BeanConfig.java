package com.example.springbootdemo.thirdtool.activemq;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</ br>
 * date: 2021/4/20 9:40</br>
 * @since JDK 1.8
 */
import javax.jms.Queue;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
public class BeanConfig {

    /**
     *  定义存放消息的队列
     */
    @Bean
    public Queue queue() {
        return new ActiveMQQueue("myQueue");
    }
}
