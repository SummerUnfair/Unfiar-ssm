package com.unfair.mq.consumer;
/*
 * @author fenghao
 * @date
 * @discription
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

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

    private interface UserSyncProcess {

        UserCommonInfo isProcessSuccess() throws Exception;
    }

    /**
     * 用户公共信息
     */
    @Data
    private static class UserCommonInfo {

        /**
         * 编号
         * 必选
         */
        private String id;
        /**
         * 名称
         * 必选
         */
        private String username;
        /**
         * 性别
         * 必选
         */
        private String sex;

        /**
         * 教育背景
         * 必选
         */
        private String education;

        /**
         * 地址
         * 必选
         */
        private String address;
        /**
         * 创建时间
         * 必选
         */
        private Date createTime;
        /**
         * 更新时间
         * 必选
         */
        private Date updateTime;
    }

    @Getter
    @AllArgsConstructor
    private class InstallInfoResult {

        private final String id;

        private final String username;

        private boolean isSuccess;

        private String status;

        private String remark;

        private String requestJson;

    }

    @Override
    protected String getConsumeGroup() {
        return CONSUME_GROUP;
    }
}
