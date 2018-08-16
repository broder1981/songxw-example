package com.songxw.universalbox.redis.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CacheService {

    @Cacheable("getObjectByParam")
    public List<Map<String, String>> getObjectByParam(String param) {
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("name", "xiaoming");
        map.put("age", "18");
        map.put("address", "beijing");
        list.add(map);
        return list;
    }

    @CacheEvict(value = {"getObjectByParam"}, allEntries = true)
    public int deleteObjectByParam(String param) {
        return 1;
    }

}
