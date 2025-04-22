package com.infrastructure.mysql.mapper;

import com.infrastructure.mysql.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE name = #{name}")
    List<User> listByName(String name);


    @Insert("INSERT INTO users(`name`)values (#{name})")
    int add(String name);
}