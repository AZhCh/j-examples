package com.github.azhch.j.example.rocketmq;


import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * PushConsumerExample
 *
 * @author zhangchen
 * @since 2023/2/28
 */
public class PushConsumerExample {
    private static final Logger LOGGER = LoggerFactory.getLogger(PushConsumerExample.class);

    public static void main(String[] args) throws InterruptedException, IOException, MQClientException {
        String namesrv = "localhost:9876";
        String topic = "TestTopic";
        DefaultMQPushConsumer pushConsumer = new DefaultMQPushConsumer("j-example");
        pushConsumer.setNamesrvAddr(namesrv);
        pushConsumer.subscribe(topic, "*");

        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                LOGGER.info("{} Received New Messages: {}", Thread.currentThread().getId(), msgs);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        pushConsumer.start();
        LOGGER.info("Push Consumer Started");
    }
}
