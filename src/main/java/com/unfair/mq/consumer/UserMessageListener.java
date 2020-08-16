package com.unfair.mq.consumer;/*
 * @author Ferao
 * @date
 * @discription
 */
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("userMessageListener")
public class UserMessageListener extends AbstractMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(UserMessageListener.class);

    private static final String CONSUME_GROUP = "please_rename_unique_group_name";

    @Override
    protected void businessProcess(MessageExt messageExt) throws Exception {
        logger.info("消费测试");
        System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), messageExt);
        System.out.println("unfair");
    }

    @Override
    protected String getConsumeGroup() {
        return CONSUME_GROUP;
    }
}
