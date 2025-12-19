package com.example.elm_m.Mapper;

import com.example.elm_m.Entity.SetMeal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SetMealMapper {
    @Select("select * from setmeal where setmealId = #{setMealId}")
    SetMeal getSetMealById(Long setMealId);
}
