package com.unfair.common;
/*
 * @author Ferao
 * @date
 * @discription
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 可覆盖设置
     * @param key
     * @param value
     */
    public void set(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }
    /**
     * 设值与过期时间
     * @param key
     * @param value
     * @param timeout
     */
    public void setex(String key,String value,Long timeout){
        stringRedisTemplate.opsForValue().set(key,value,timeout, TimeUnit.SECONDS);
    }
    /**
     * 设值与过期时间
     * @param key
     * @param value
     * @param timeout
     */
    public void setex(String key,Integer value,Long timeout){
        stringRedisTemplate.opsForValue().set(key,value+"",timeout, TimeUnit.SECONDS);
    }
    /**
     * 获取key值
     * @param key
     * @return
     */
    public String get(String key){
        return  stringRedisTemplate.opsForValue().get(key);
    }
    /**
     * 删除key
     * @param key
     */
    public void del(String key){
        stringRedisTemplate.delete(key);
    }
    /**
     *  如果key 存在 返回false，如果不存在，set value return true
     * @param key key
     * @param value value
     * @return 如果key 存在 返回false，如果不存在，set value return true
     */
    public Boolean setnx(String key,String value){
        return stringRedisTemplate.opsForValue().setIfAbsent(key,value);
    }
    /**
     * 对key对应值加by
     * @param key
     * @param by
     * @return
     */
    public  Double incr(String key, double by){
        return  stringRedisTemplate.opsForValue().increment(key,by);
    }
    /**
     * 对key对应值加by
     * @param key
     * @param by
     * @return
     */
    public  Double incr(String key, int by){
        return  stringRedisTemplate.opsForValue().increment(key,Double.valueOf(""+by));
    }
    /**
     * 查询是否过期
     * @param key key
     * @param timeout 时间，单位是秒啊
     * @return 是否过期
     */
    public Boolean expire(String key,Long timeout){
        return stringRedisTemplate.expire(key,timeout,TimeUnit.SECONDS);
    }
    /**
     *  获取所有的zset
     * @param key keys
     * @return values
     */
    public Set<String> zsetRange(String key){
        Set<String> range = stringRedisTemplate.opsForZSet().range(key, 0L, -1L);
        return range;
    }
    /**
     * zset add
     * @param key key
     * @param list value
     * @return 影响的条数
     */
    public Long addZset(String key , List<Long> list){
        Set<ZSetOperations.TypedTuple<String>> values = new HashSet<>();
        for (Long id : list) {
            ZSetOperations.TypedTuple<String> tuple = new DefaultTypedTuple<>(id + "",new Double(id));
            values.add(tuple);
        }
        Long range = stringRedisTemplate.opsForZSet().add(key,values);
        return range;
    }
    /***
     * 根据分数排序
     * @param key
     * @return
     */
    public Set<ZSetOperations.TypedTuple<String>> rangeByScore(String key){
        Set<ZSetOperations.TypedTuple<String>> strings = stringRedisTemplate.opsForZSet().rangeByScoreWithScores(key, 0, 500);
        return strings;
    }
    /***
     * 增加zset
     * @param key
     * @param value
     * @param score
     * @return
     */
    public Boolean addZset(String key,String value,Double score){
        return stringRedisTemplate.opsForZSet().add(key, value, score);
    }
    /***
     * 删除zset
     * @param key
     * @param value
     * @return
     */
    public boolean removeZset(String key,String value){
        Long succ = stringRedisTemplate.opsForZSet().remove(key, value);
        return succ >= 0;
    }
    /**
     * 实现命令：TTL key，以秒为单位，返回给定 key的剩余生存时间(TTL, time to live)。
     * @param key
     * @return
     */
    public long ttl(String key) {
        return stringRedisTemplate.getExpire(key);
    }
    /**
     * 实现命令：KEYS pattern，查找所有符合给定模式 pattern的 key
     */
    public Set<String> keys(String pattern){
        return stringRedisTemplate.keys(pattern);
    }
    /**
     * 实现命令：HSET key field value，将哈希表 key中的域 field的值设为 value
     * @param key
     * @param field
     * @param value
     */
    public void hset(String key, String field, Object value) {
        stringRedisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 实现命令：HGET key field，返回哈希表 key中给定域 field的值
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field) {
        return (String)stringRedisTemplate.opsForHash().get(key, field);
    }

    /**
     * 实现命令：HDEL key field [field ...]，删除哈希表 key 中的一个或多个指定域，不存在的域将被忽略。
     * @param key
     * @param fields
     */
    public void hdel(String key, Object... fields) {
        stringRedisTemplate.opsForHash().delete(key, fields);
    }

    /**
     * 为哈希表 key 中的域 field 的值加上增量 increment 。
     * 增量也可以为负数，相当于对给定域进行减法操作。
     如果 key 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。
     如果域 field 不存在，那么在执行命令前，域的值被初始化为 0
     * @param key kei
     * @param field field
     * @param increment 增量
     * @return 执行 HINCRBY 命令之后，哈希表 key 中域 field 的值
     */
    public Long hIncrBy(String key,String field,Long increment ){
        return stringRedisTemplate.opsForHash().increment(key, field, increment);
    }

    /**
     * 为哈希表 key 中的域 field 的值加上增量 increment 。
     * 增量也可以为负数，相当于对给定域进行减法操作。
     如果 key 不存在，一个新的哈希表被创建并执行 HINCRBY 命令。
     如果域 field 不存在，那么在执行命令前，域的值被初始化为 0
     * @param key kei
     * @param field field
     * @param increment 增量
     * @return 执行 HINCRBY 命令之后，哈希表 key 中域 field 的值
     */
    public Double hIncrBy(String key,String field,Double increment ){
        return stringRedisTemplate.opsForHash().increment(key, field, increment);
    }
}
