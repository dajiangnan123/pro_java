package com.infrastructure.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisDemo {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void operateString() {
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        valueOps.set("stringKey", "stringValue");
        Object value = valueOps.get("stringKey");
        log.info("String value: {}", value);

        valueOps.set("stringKeyWithExpire", "expireValue", 60, TimeUnit.SECONDS);
        Object expireValue = valueOps.get("stringKeyWithExpire");
        log.info("String expireValue: {}", expireValue);
    }

    public void operateHash() {
        HashOperations<String, String, Object> hashOps = redisTemplate.opsForHash();
        String hashKey = "hashKey";
        hashOps.put(hashKey, "field1", "value1");
        hashOps.put(hashKey, "field2", "value2");
        Object fieldValue = hashOps.get(hashKey, "field1");
        log.info("Hash field value: {}", fieldValue);
        Map<String, Object> entries = hashOps.entries(hashKey);
        log.info("Hash entries: {}", entries);
    }

    public void operateList() {
        ListOperations<String, Object> listOps = redisTemplate.opsForList();
        String listKey = "listKey";
        listOps.leftPush(listKey, "element1");
        listOps.leftPush(listKey, "element2");
        Long size = listOps.size(listKey);
        log.info("List size: {}", size);
        List<Object> elements = listOps.range(listKey, 0, -1);
        log.info("List elements: {}", elements);
    }

    public void operateSet() {
        SetOperations<String, Object> setOps = redisTemplate.opsForSet();
        String setKey = "setKey";
        setOps.add(setKey, "member1", "member2", "member3");
        Set<Object> members = setOps.members(setKey);
        log.info("Set members: {}", members);
        Boolean isMember = setOps.isMember(setKey, "member1");
        log.info("Is member: {}", isMember);
    }

    public void operateZSet() {
        ZSetOperations<String, Object> zSetOps = redisTemplate.opsForZSet();
        String zSetKey = "zSetKey";
        zSetOps.add(zSetKey, "zMember1", 1.0);
        zSetOps.add(zSetKey, "zMember2", 2.0);
        Set<Object> rangeByScore = zSetOps.rangeByScore(zSetKey, 0, 2);
        log.info("ZSet range by score: {}", rangeByScore);
    }

    public void delete() {
        redisTemplate.delete(Arrays.asList("stringKey", "stringKeyWithExpire",
                "hashKey", "listKey", "zSetKey"));
    }
}
