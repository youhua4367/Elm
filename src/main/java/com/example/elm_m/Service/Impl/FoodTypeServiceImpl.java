package com.example.elm_m.Service.Impl;

import com.example.elm_m.Entity.FoodType;
import com.example.elm_m.Mapper.FoodTypeMapper;
import com.example.elm_m.Service.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodTypeServiceImpl implements FoodTypeService {

    @Autowired
    private FoodTypeMapper foodTypeMapper;

    /**
     * 获取食物分类
     * @return 食物分类列表
     */
    @Override
    public List<FoodType> getFoodType() {

        return foodTypeMapper.list();
    }
}
