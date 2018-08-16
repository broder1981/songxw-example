package com.songxw.universalbox.redis;

import com.songxw.universalbox.redis.cache.CacheService;
import com.songxw.universalbox.redis.database.RedisDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisDemo {

    @Autowired
    private CacheService cacheService;
    @Autowired
    private RedisDatabaseService redisDatabaseService;

    /**
     * redis基本数据操作
     */
    @RequestMapping(value = "/redisBaseOperation")
    public void redisBaseOperation () {
        //redisDatabaseService.redisStringToString();
        redisDatabaseService.redisObjectToString();
    }

    @RequestMapping(value = "/getObjectByParam")
    public void getObjectByParam() {
        System.out.println(cacheService.getObjectByParam("").toString());
    }

    @RequestMapping(value = "/deleteObjectByParam")
    public void deleteObjectByParam() {
        System.out.println(cacheService.deleteObjectByParam(""));
    }
}
