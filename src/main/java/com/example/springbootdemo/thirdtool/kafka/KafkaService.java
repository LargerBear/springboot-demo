package com.example.springbootdemo.thirdtool.kafka;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author LargerBear</ br>
 * date: 2020/12/17 14:32</br>
 * @since JDK 1.8
 */
//@Service
@Slf4j
public class KafkaService {

    @Resource
    private KafkaConfig config;



    /**
     *异步发送消息(默认topic为配置文件中的topic)
     * @param msg
     */
    public void sendAsyncMsg(String msg) throws RuntimeException{
        log.info("准备发送消息为：{}", msg);
        //发送消息
        this.sendAsyncMsg(config.getProducer_topic(), msg);
    }

    /**
     *异步发送消息
     * @param topic
     * @param msg
     */
    public void sendAsyncMsg(String topic, String msg) throws RuntimeException{
        log.info("准备发送消息为：{}", msg);
        log.info("发送topic为：{}", topic);
        //发送消息
        ListenableFuture<SendResult<String, Object>> future = config.kafkaTemplate().send(topic,"data", msg);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable throwable) {
                //发送失败的处理
                log.info(topic + " - 生产者 发送消息失败：" + throwable.getMessage());
                throw new RuntimeException("kafka发送消息失败");
            }

            @Override
            public void onSuccess(SendResult<String, Object> stringObjectSendResult) {
                //成功的处理
                log.info(topic + " - 生产者 发送消息成功：" + stringObjectSendResult.toString());
            }
        });
    }

    /**
     * 同步发送消息(默认topic为配置文件中的topic)
     * @param msg
     * @return
     * @throws Exception
     */
    public SendResult<String, Object> sendSyncMsg(String msg) throws Exception{
        return config.kafkaTemplate().send(config.getProducer_topic(), "data", msg).get();
    }

    /**
     *同步发送消息
     * @param topic
     * @param msg
     * @return
     * @throws Exception
     */
    public SendResult<String, Object> sendSyncMsg(String topic, String msg) throws Exception{
        return config.kafkaTemplate().send(topic, "data", msg).get();
    }

//    /**
//     *指定topic和拉取时间消费消息
//     * @param topic
//     * @param time
//     * @return
//     */
//    public ConsumerRecords<String, Object> pollMsg(String topic, long time){
//        Consumer<String, Object> consumer = config.consumerFactory().createConsumer();
//        consumer.subscribe(Arrays.asList(topic,","));
//        while (true) {
//            return consumer.poll(Duration.ofMillis(time));
//        }
//    }




    /**
     *
     * kafka消息监听接收待办任务
     * @param record
     * @param topic
     */
//    @KafkaListener(topics = "${kafka.consumer.topic}", groupId = "${kafka.consumer.group-id}")
    public void consumerTask(ConsumerRecord<?, ?> record, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        Optional message = Optional.ofNullable(record.value());
        if (message.isPresent()) {
            JSONObject msg = JSONObject.parseObject(message.get().toString());
            log.info("topic_test1 消费了： Topic:" + topic + ",Message:" + msg);
            //业务处理 消息接收持久化到数据库
            //设置自动提交
//            ack.acknowledge();
        }
    }

}
