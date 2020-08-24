package com.unfair.mq.producer;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fenghao
 * @discription
 * @create 2020-08-21 21:56
 */

@Service
public class MessageProducer {

    private static final Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    @Autowired
    private DefaultMQProducer defaultMQProducer;

    public void producerMessage(String topic, String tags, String keys, String msg) {

        try {
            Message message = new Message();

            message.setTopic(topic);
            message.setTags(tags);
            message.setKeys(keys);
            message.putUserProperty("producerGroup", defaultMQProducer.getProducerGroup());
            message.setBody(msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
            SendResult sendResult = defaultMQProducer.send(message);
            if (SendStatus.SEND_OK.equals(sendResult.getSendStatus())) {
                logger.info("topic:{},tags:{},message:{},发送到MQ成功", topic, tags, msg);
            } else {
                logger.info("topic:{},tags:{},message:{},发送到MQ失败", topic, tags, msg);
            }
        } catch (Exception e) {
            logger.info("topic:{},tags:{},message:{},发送到MQ异常", topic, tags, msg);
            logger.error(e.getMessage(), e);
        }
    }
}
