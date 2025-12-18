package com.example.elm_m.Mapper;

import com.example.elm_m.Entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("select * from category")
    List<Category> getCategoryList();
}
