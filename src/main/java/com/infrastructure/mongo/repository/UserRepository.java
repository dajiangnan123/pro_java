package com.infrastructure.mongo.repository;

import com.infrastructure.mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByName(String name);

    //由于 street 是嵌套在 Address 类中的字段，需要使用特定的命名规则
    List<User> findByAddressesStreet(String street);
}
