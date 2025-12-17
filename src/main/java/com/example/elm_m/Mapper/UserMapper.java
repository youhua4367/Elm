package com.example.elm_m.Mapper;

import com.example.elm_m.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where userId = #{userId}")
    User getByUserId(String userId);
}
