package com.example.elm_m.Mapper;

import com.example.elm_m.Entity.FoodType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FoodTypeMapper {
    @Select("select * from food_type")
    List<FoodType> list();
}
