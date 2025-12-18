package com.example.elm_m.Mapper;

import com.example.elm_m.Entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("select * from user where userId = #{userId}")
    User getByUserId(String userId);

    @Insert("insert into user (userId, password, userName, userSex, userImg, delTag) " +
            "values (#{userId}, #{password}, #{userName}, #{userSex}, #{userImg}, #{delTag})")
    void insert(User user1);


    void update(User user);
}
