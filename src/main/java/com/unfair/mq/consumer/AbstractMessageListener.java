package com.unfair.mq.consumer;
/*
 * @author Ferao
 * @date
 * @discription
 */
import com.unfair.utils.JedisCacheManager;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractMessageListener implements MessageListenerConcurrently {

    private static final Logger logger = LoggerFactory.getLogger(AbstractMessageListener.class);

    @Autowired
    private JedisCacheManager jedisCacheManager;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> megs, ConsumeConcurrentlyContext context) {
        for (MessageExt messageExt : megs){
            logger.info("消息消费开始。topic:{},tags:{},KEY:{},ID:{}",
                    messageExt.getTopic(),
                    messageExt.getTags(),
                    messageExt.getKeys(),
                    messageExt.getMsgId());

            boolean lock = jedisCacheManager.lock("unfair:consume:" + getConsumeGroup() + ":" + messageExt.getKeys(),"1", 60 * 60);

            System.out.println(lock);
            if(!lock) {
                logger.info("消息正在被消费，此次不处理");
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }

            try {
                logger.info("业务处理开始");
                businessProcess(messageExt);
                logger.info("消费结果 : {}", "success");
            } catch (Exception e) {
                logger.error("消息处理异常 : topic:{},tags:{},KEY:{},ID:{}",
                        messageExt.getTopic(),
                        messageExt.getTags(),
                        messageExt.getKeys(),
                        messageExt.getMsgId(),
                        e);
                e.printStackTrace();
            }finally {
                jedisCacheManager.unlock("fpm_gateway:consume:" + getConsumeGroup() + ":" + messageExt.getKeys(), "1");
            }
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
    protected abstract void businessProcess(MessageExt messageExt) throws Exception;

    protected abstract String getConsumeGroup();
}
