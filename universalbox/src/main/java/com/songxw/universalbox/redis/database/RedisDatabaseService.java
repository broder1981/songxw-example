package com.songxw.universalbox.redis.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisDatabaseService {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 以String方式存储String数据
     */
    public void redisStringToString () {
        //向redis里存值
        stringRedisTemplate.opsForValue().set("strKey", "strValue");
        //向redis里存值,同时设置超时时间
        stringRedisTemplate.opsForValue().set("strKey", "strValue", 1, TimeUnit.HOURS);
        //从redis里取值
        System.out.println(stringRedisTemplate.opsForValue().get("strKey"));
    }

    /**
     * 以String方式存储Object数据
     */
    public void redisObjectToString () {
        //序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        //构建对象
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("name", "xiaoming");
        map.put("age", "25");
        list.add(map);
        //向redis里存值
        redisTemplate.opsForValue().set("strKey", list);
        //向redis里存值,同时设置超时时间
        redisTemplate.opsForValue().set("strKey", list, 1, TimeUnit.HOURS);
        //从redis里取值
        System.out.println(redisTemplate.opsForValue().get("strKey"));
    }

}
