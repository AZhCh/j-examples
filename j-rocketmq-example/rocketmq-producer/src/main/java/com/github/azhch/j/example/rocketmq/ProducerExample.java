package com.github.azhch.j.example.rocketmq;


import com.oracle.jrockit.jfr.Producer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * ProducerExample
 *
 * @author zhangchen
 * @since 2023/2/28
 */
public class ProducerExample {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerExample.class);

    public static void main(String[] args) throws IOException, MQClientException, MQBrokerException, RemotingException, InterruptedException {
        String namesrv = "172.200.60.27:9876";
        String topic = "TestTopic";

        DefaultMQProducer producer = new DefaultMQProducer("j-example");
        producer.setNamesrvAddr(namesrv);

        producer.start();

        for (int i = 0; i < 100; i++) {
            Message keyA = new Message(topic, topic, "keyA", ("Hello RocketMQ " + i).getBytes());
            SendResult result = producer.send(keyA);
            LOGGER.info("Send message successfully,messageId={}",result.getMsgId());
        }

        producer.shutdown();
    }
}
