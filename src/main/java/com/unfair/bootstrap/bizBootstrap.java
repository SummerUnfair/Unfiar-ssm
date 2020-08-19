package com.unfair.bootstrap;

import com.unfair.db.dao.UserMapper;
import com.unfair.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * biz引导程序<br>
 * 〈功能详细描述〉
 *
 * @author fenghao
 * @since 1.0.0
 */
@Service("bizBootstrap")
public class bizBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger LOGGER = LoggerFactory.getLogger(bizBootstrap.class);

    @Autowired
    private RedisService redisService;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {   //root application context 没有parent
            //其它逻辑
            iniRedisInfo();
            LOGGER.info("==========系统启动成功==========");
        }
    }

    private void iniRedisInfo(){

        redisService.del("unfair:user_node_info");
        int count = userMapper.countByExample(null);
        LOGGER.info("查询服务结束,共[{}]条用户信息",count);
        if (count!=0){
            LOGGER.info("==========Redis初始化成功==========");
        }else{
            LOGGER.info("==========Redis初始化失败==========");
        }
    }
}
