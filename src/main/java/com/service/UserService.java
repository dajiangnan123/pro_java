package com.service;

import com.infrastructure.mysql.mapper.UserMapper;
import com.infrastructure.mysql.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<Users> getUsersByName(String token) {
        return userMapper.selectByName(token);
    }
}