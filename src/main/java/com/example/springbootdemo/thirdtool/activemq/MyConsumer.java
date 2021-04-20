//package com.example.springbootdemo.thirdtool.activemq;
//
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//
//import javax.jms.*;
//
//
///**
// * Description: </br>
// * <p>版权所有：</p>
// * 未经本公司许可，不得以任何方式复制或使用本程序任何部分
// * <p>
// * 杭州孚立计算机软件有限公司
// *
// * @author LargerBear</   br>
// * date: 2021/4/20 9:05</br>
// * @since JDK 1.8
// */
//
//
//public class MyConsumer {
//
//    private static final String ACTIVEMQ_URL = "tcp://192.168.0.78:61616";
//
//    public static void main(String[] args) throws JMSException {
//        // 创建连接工厂
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
//        // 创建连接
//        Connection connection = activeMQConnectionFactory.createConnection();
//        // 打开连接
//        connection.start();
//        // 创建会话
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        // 创建队列目标,并标识队列名称，消费者根据队列名称接收数据
//        Destination destination = session.createQueue("myQueue");
//        // 创建消费者
//        MessageConsumer consumer = session.createConsumer(destination);
//        // 创建消费的监听
//        consumer.setMessageListener(new MessageListener() {
//
//            @Override
//            public void onMessage(Message message) {
//                TextMessage textMessage = (TextMessage) message;
//                try {
//                    System.out.println("消费的消息：" + textMessage.getText());
//                } catch (JMSException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//}
