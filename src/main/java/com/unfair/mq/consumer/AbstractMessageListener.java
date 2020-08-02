package com.unfair.mq.consumer;
/*
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

import java.util.List;

public abstract class AbstractMessageListener implements MessageListenerConcurrently {

    private static final Logger logger = LoggerFactory.getLogger(AbstractMessageListener.class);

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> megs, ConsumeConcurrentlyContext context) {
        for (MessageExt messageExt : megs){
            logger.info("消息消费开始。topic:{},tags:{},KEY:{},ID:{}",
                    messageExt.getTopic(),
                    messageExt.getTags(),
                    messageExt.getKeys(),
                    messageExt.getMsgId());

            try {
                businessProcess(messageExt);
                logger.info("消费结果 : {}", "success");
            } catch (Exception e) {
                logger.error("消息处理异常。topic:{},tags:{},KEY:{},ID:{}",
                        messageExt.getTopic(),
                        messageExt.getTags(),
                        messageExt.getKeys(),
                        messageExt.getMsgId(),
                        e);
                e.printStackTrace();
            }finally {

            }
        }

        return null;
    }

    protected abstract void businessProcess(MessageExt messageExt) throws Exception;

}
