package com.yh.line.chat.data.redis;

import com.yh.line.chat.data.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 一周有多少秒
     */
    private static final long WEEK_SECONDS = 7 * 24 * 60 * 60;


    /**
     * 将 key，value 存放到redis数据库中，默认设置过期时间为一周
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, JsonUtil.beanToJson(value), WEEK_SECONDS, TimeUnit.SECONDS);
    }
    /**
     * 将 key，value 存放到redis数据库中，默认设置过期时间为一周
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value, WEEK_SECONDS, TimeUnit.SECONDS);
    }


    /**
     * 将 key，value 存放到redis数据库中，设置过期时间单位是秒
     *
     * @param key
     * @param value
     * @param expireTime
     */
    public void set(String key, Object value, long expireTime) {
        redisTemplate.opsForValue().set(key, JsonUtil.beanToJson(value), expireTime, TimeUnit.SECONDS);
    }

    /**
     * 将 key，value 存放到redis数据库中，设置过期时间单位是秒
     *
     * @param key
     * @param value
     * @param expireTime
     */
    public void set(String key, String value, long expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 判断 key 是否在 redis 数据库中
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 获取与 key 对应的对象
     * @param key
     * @param clazz 目标对象类型
     * @param <T>
     * @return
     */
    public <T> T get(String key, Class<T> clazz) {
        String s = get(key);
        if (s == null) {
            return null;
        }
        return JsonUtil.jsonToBean(s, clazz);
    }

    /**
     * 获取 key 对应的字符串
     * @param key
     * @return
     */
    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除 key 对应的 value
     * @param key
     */
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 缓存set
     * @param key
     * @param value
     */
    public void cacheSet(String key, String value) {
        cacheSet(key, value, WEEK_SECONDS);
    }

    /**
     * 缓存set
     * @param key
     * @param value
     * @param time
     */
    public void cacheSet(String key, String value, long time) {
        SetOperations<String, String> setOps = redisTemplate.opsForSet();
        setOps.add(key, value);
        if(time > 0) {
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    /**
     * 缓存set
     * @param key
     * @param value
     * @param time
     */
    public void cacheSet(String key, Set<String> value, long time) {
        SetOperations<String, String> setOps = redisTemplate.opsForSet();
        setOps.add(key, value.toArray(new String[value.size()]));
        if(time > 0) {
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    /**
     * 缓存set
     * @param key
     * @param value
     */
    public void cacheSet(String key, Set<String> value) {
        cacheSet(key, value, WEEK_SECONDS);
    }

    /**
     * 获取set缓存
     * @param key
     * @return
     */
    public Set<String> cacheSet(String key) {
        SetOperations<String, String> setOps = redisTemplate.opsForSet();
        return setOps.members(key);
    }

    /**
     * 获取set缓存，转化成对应对象
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> Set<T>  getSet(String key, final Class<T> clazz) {
        SetOperations<String, String> setOps = redisTemplate.opsForSet();
        Set<String> members = setOps.members(key);
        return members.stream().map(m -> JsonUtil.jsonToBean(m, clazz)).collect(Collectors.toSet());
    }

    /**
     * 判断set中是否存在
     * @param key
     * @param member
     * @return
     */
    public boolean isSetCache(String key, String member) {
        SetOperations<String, String> setOps = redisTemplate.opsForSet();
        return setOps.isMember(key, member);
    }

    /**
     * 缓存list
     * @param key
     * @param value
     * @param time
     */
    public void cacheList(String key, List<String> value, long time) {
        ListOperations<String, String> listOps = redisTemplate.opsForList();
        listOps.rightPushAll(key, value);
        if(time > 0) {
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    /**
     * 缓存list
     * @param key
     * @param value
     * @param time
     */
    public void cacheList(String key, String value, long time) {
        redisTemplate.opsForList().rightPush(key, value);
        if(time > 0) {
            redisTemplate.expire(key, time, TimeUnit.SECONDS);
        }
    }

    /**
     * 缓存list
     * @param key
     * @param value
     */
    public void cacheList(String key, List<String> value) {
        cacheList(key, value, WEEK_SECONDS);
    }

    /**
     * 缓存list
     * @param key
     * @param value
     */
    public void cacheList(String key, String value) {
        cacheList(key, value, WEEK_SECONDS);
    }

    /**
     * 获取list
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> getList(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 获取list缓存，转化成对应对象
     * @param key
     * @param start
     * @param end
     * @param classType
     * @param <T>
     * @return
     */
    public <T> List<T> getList(String key, long start, long end, final Class<T> classType) {
        return redisTemplate.opsForList().range(key, start, end)
                .stream()
                .map(v -> JsonUtil.jsonToBean(v, classType))
                .collect(Collectors.toList());
    }

    /**
     * 获取全部list缓存
     * @param key
     * @return
     */
    public List<String> getListAll(String key) {
        return getList(key, 0, -1);
    }

    /**
     * 获取全部list缓存，转化成对应对象
     * @param key
     * @param classType
     * @param <T>
     * @return
     */
    public <T> List<T> getListAll(String key, final Class<T> classType) {
        return getList(key, 1, -1, classType);
    }
}
