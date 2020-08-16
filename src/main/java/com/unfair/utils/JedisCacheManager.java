package com.unfair.utils;
/*
 * @author Ferao
 * @date
 * @discription
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Collections;

@Component
public class JedisCacheManager {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ShardedJedisPool shardedJedisPool;

    @Autowired
    public JedisCacheManager(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }

    /**
     * 缓存过期时间
     */
    private static final int SECONDS = 5 * 60;

    /**
     * 删除成功标识
     */
    private static final Long RELEASE_SUCCESS = 1L;


    /**
     * 获取ShardedJedis
     * @return
     */
    private ShardedJedis getRedisClient() {
        ShardedJedis shardedJedis = null;
        try {
            shardedJedis = shardedJedisPool.getResource();
        } catch (Exception e) {
            logger.error("获取redis资源发生异常{}", e.getMessage());
            logger.error(e.getMessage(), e);
        }
        return shardedJedis;
    }

    /**
     * 将 key 的值设为 value ，当且仅当 key 不存在。且设置过期时间
     * @param key
     * @param value
     * @return
     */
    public Long setnx(String key, String value) {
        Long result = 0L;
        ShardedJedis shardedJedis = this.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            String res = shardedJedis.set(key, value, "nx", "ex", SECONDS);
            if (res != null) {
                result = 1L;
            }
        } catch (Exception e) {
            logger.error("redis.setnx()发生异常{}", e.getMessage());
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    /**
     * 删除给定的一个key
     * @param key
     * @return
     */
    public Long del(String key) {
        Long result = null;
        ShardedJedis shardedJedis = this.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.del(key);
        } catch (Exception e) {
            logger.error("redis.del()发生异常{}" , e.getMessage());
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    /**
     * 将 key 的值设为 value ，当且仅当 key 不存在。且设置过期时间
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public boolean lock(String key, String value, int seconds) {
        boolean result = false;
        ShardedJedis shardedJedis = this.getRedisClient();
        if (shardedJedis == null) {
            return false;
        }
        try {
            String res = shardedJedis.set(key, value, "nx", "ex", seconds);
            if (res != null) {
                result = true;
            }
        } catch (Exception e) {
            logger.error("redis.Lock()发生异常{}", e.getMessage());
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    /**
     * 释放锁
     * @param key
     * @param value
     * @return
     */
    public boolean unlock(String key, String value) {
        boolean result = false;
        ShardedJedis shardedJedis = this.getRedisClient();
        if (shardedJedis == null) {
            return false;
        }
        try {
            Jedis jedis = shardedJedis.getShard(key);
            String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
            Object object = jedis.eval(script, Collections.singletonList(key), Collections.singletonList(value));
            if (RELEASE_SUCCESS.equals(object)) {
                result = true;
            }
        } catch (Exception e) {
            logger.error("redis.Lock()发生异常" + e.getMessage());
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    /**
     * 获取缓存值
     * @param key
     * @return
     */
    public String get(String key) {
        String result = "";
        ShardedJedis shardedJedis = this.getRedisClient();
        if (shardedJedis == null) {
            return null;
        }
        try {
            result = shardedJedis.get(key);
        } catch (Exception e) {
            logger.error("redis.get()发生异常" + e.getMessage());
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    /**
     * 获取自增数量
     * @param key
     * @return
     */
    public Long incr(String key) {
        Long result = 0L;
        ShardedJedis shardedJedis = this.getRedisClient();
        if (shardedJedis == null) {
            return 0L;
        }
        try {
            result = shardedJedis.incr(key);
        } catch (Exception e) {
            logger.error("redis.get()发生异常" + e.getMessage());
        } finally {
            shardedJedis.close();
        }
        return result;
    }

    public Long incr(String key, String field) {
        Long result = 0L;
        ShardedJedis shardedJedis = this.getRedisClient();
        if (shardedJedis == null) {
            return 0L;
        }
        try {
            result = shardedJedis.hincrBy(key, field, 1L);
        } catch (Exception e) {
            logger.error("redis.hincrBy()发生异常" + e.getMessage());
        } finally {
            shardedJedis.close();
        }
        return result;
    }
}
