package com.infrastructure;

import com.google.gson.Gson;
import com.infrastructure.mysql.mapper.UserMapper;
import com.infrastructure.mysql.model.User;
import com.infrastructure.redis.RedisDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class Demo {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisDemo redisDemo;

    public void mysqlDemo() {
        String name = "张三";
        int result = userMapper.add(name);
        log.info("add result {}", result);
        List<User> users = userMapper.listByName(name);
        log.info("listByName {}", new Gson().toJson(users));
        result = userMapper.delete(name);
        log.info("delete result {}", result);
    }

    public void redisDemo() {
        redisDemo.operateString();
        redisDemo.operateHash();
        redisDemo.operateList();
        redisDemo.operateSet();
        redisDemo.operateZSet();
        redisDemo.delete();
    }
}
