package com.example.springbootdemo.thirdtool.activemq;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;

/**
 * Description: </br>
 * <p>版权所有：</p>
 * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
 * <p>
 * 杭州孚立计算机软件有限公司
 *
 * @author LargerBear</   br>
 * date: 2021/4/20 9:03</br>
 * @since JDK 1.8
 */
@RestController
public class ActivemqService {

    @Resource
    private Queue queue;

    @Resource
    private JmsMessagingTemplate template;

    @Resource
    private ConnectionFactory factory;

    /**
     * 发送消息
     *
     * @param name
     */
    @RequestMapping("send")
    public void send(String name) {
        //方法一：添加消息到消息队列
        template.convertAndSend(queue, name);
        //方法二：这种方式不需要手动创建queue，系统会自行创建名为test的队列
        //jmsMessagingTemplate.convertAndSend("test", name);
    }


    //需要给topic定义独立的JmsListenerContainer
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic() {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(factory);
        return bean;
    }


    @JmsListener(destination = "myQueue")
    public void receiveTopic(String text) {
        System.out.println(text);
    }
}
