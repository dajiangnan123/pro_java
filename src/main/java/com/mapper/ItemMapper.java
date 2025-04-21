package com.mapper;

import com.model.Item;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ItemMapper {
    @Select("SELECT * FROM items WHERE token = #{token}")
    List<Item> selectByToken(String token);
}