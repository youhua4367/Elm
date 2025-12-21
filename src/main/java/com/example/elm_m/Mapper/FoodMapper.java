package com.example.elm_m.Mapper;

import com.example.elm_m.Entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FoodMapper {
    @Select("select * from food where foodId = #{foodId}")
    Food getFoodById(Long foodId);

    @Select("select * from food where businessId = #{businessId}")
    List<Food> getByBusinessId(Long businessId);
}
