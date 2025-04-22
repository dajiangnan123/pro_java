package com.infrastructure.mysql.mapper;

import com.infrastructure.mysql.model.Users;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE name = #{name}")
    List<Users> selectByName(String token);
}