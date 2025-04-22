package com.infrastructure.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class RedisOperationService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 操作 String 类型
    public void operateString() {
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        // 设置值
        valueOps.set("stringKey", "stringValue");
        // 获取值
        Object value = valueOps.get("stringKey");
        System.out.println("String value: " + value);
        // 设置带过期时间的值
        valueOps.set("stringKeyWithExpire", "expireValue", 60, TimeUnit.SECONDS);
    }

    // 操作 Hash 类型
    public void operateHash() {
        HashOperations<String, String, Object> hashOps = redisTemplate.opsForHash();
        String hashKey = "hashKey";
        // 插入字段和值
        hashOps.put(hashKey, "field1", "value1");
        hashOps.put(hashKey, "field2", "value2");
        // 获取单个字段的值
        Object fieldValue = hashOps.get(hashKey, "field1");
        System.out.println("Hash field value: " + fieldValue);
        // 获取所有字段和值
        Map<String, Object> entries = hashOps.entries(hashKey);
        System.out.println("Hash entries: " + entries);
    }

    // 操作 List 类型
    public void operateList() {
        ListOperations<String, Object> listOps = redisTemplate.opsForList();
        String listKey = "listKey";
        // 从左边插入元素
        listOps.leftPush(listKey, "element1");
        listOps.leftPush(listKey, "element2");
        // 获取列表长度
        Long size = listOps.size(listKey);
        System.out.println("List size: " + size);
        // 获取列表元素
        List<Object> elements = listOps.range(listKey, 0, -1);
        System.out.println("List elements: " + elements);
    }

    // 操作 Set 类型
    public void operateSet() {
        SetOperations<String, Object> setOps = redisTemplate.opsForSet();
        String setKey = "setKey";
        // 添加元素
        setOps.add(setKey, "member1", "member2", "member3");
        // 获取集合元素
        Set<Object> members = setOps.members(setKey);
        System.out.println("Set members: " + members);
        // 判断元素是否存在
        Boolean isMember = setOps.isMember(setKey, "member1");
        System.out.println("Is member: " + isMember);
    }

    // 操作 Sorted Set 类型
    public void operateZSet() {
        ZSetOperations<String, Object> zSetOps = redisTemplate.opsForZSet();
        String zSetKey = "zSetKey";
        // 添加元素并设置分数
        zSetOps.add(zSetKey, "zMember1", 1.0);
        zSetOps.add(zSetKey, "zMember2", 2.0);
        // 获取指定分数范围的元素
        Set<Object> rangeByScore = zSetOps.rangeByScore(zSetKey, 0, 2);
        System.out.println("ZSet range by score: " + rangeByScore);
    }
}
