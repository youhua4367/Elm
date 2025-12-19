package com.example.elm_m.Mapper;

import com.example.elm_m.Entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FoodMapper {
    @Select("select * from food where foodId = #{foodId}")
    Food getFoodById(Long foodId);
}
