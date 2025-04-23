package com.infrastructure;

import com.google.gson.Gson;
import com.infrastructure.mongo.model.Address;
import com.infrastructure.mongo.MongoDemo;
import com.infrastructure.mysql.mapper.UserMapper;
import com.infrastructure.mysql.model.User;
import com.infrastructure.redis.RedisDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class Demo {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisDemo redisDemo;
    @Autowired
    private MongoDemo mongoDemo;

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

    public void mongoDemo() {
        mongoDemo.createUser(new com.infrastructure.mongo.model.User("id", "name", 18,
                Collections.singletonList(new Address("street", "city"))));
        List<com.infrastructure.mongo.model.User> users = mongoDemo.getAllUsers();
        log.info("listUsers {}", new Gson().toJson(users));
        users = mongoDemo.getUsersByName("name");
        log.info("userByName {}", new Gson().toJson(users));
        users = mongoDemo.findByAddressesStreet("street");
        log.info("userByStreet {}", new Gson().toJson(users));
        com.infrastructure.mongo.model.User user = mongoDemo.getUserById("id");
        log.info("user {}", new Gson().toJson(user));
        mongoDemo.deleteUser("id");
        user = mongoDemo.getUserById("id");
        log.info("user {}", new Gson().toJson(user));
    }

}
