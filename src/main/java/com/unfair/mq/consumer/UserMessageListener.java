package com.unfair.mq.consumer;/*
 * @author Ferao
 * @date
 * @discription
 */

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("userMessageListener")
public class UserMessageListener implements MessageListenerConcurrently {

    private static final Logger logger = LoggerFactory.getLogger(UserMessageListener.class);

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), list);
        System.out.println("unfair");
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
