package com.infrastructure.mongo;

import com.infrastructure.mongo.model.User;
import com.infrastructure.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoDemo {
    @Autowired
    private UserRepository userRepository;

    // 创建用户
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // 获取所有用户
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 根据ID获取用户
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> findByAddressesStreet(String street) {
        return userRepository.findByAddressesStreet(street);
    }

    // 更新用户
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // 删除用户
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}