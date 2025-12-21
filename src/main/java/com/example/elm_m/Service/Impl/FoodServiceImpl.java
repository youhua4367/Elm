package com.example.elm_m.Service.Impl;

import com.example.elm_m.Entity.Food;
import com.example.elm_m.Mapper.FoodMapper;
import com.example.elm_m.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    /**
     * 获取食物列表
     * @param businessId 商家 id
     * @return 获取食物列表
     */
    @Override
    public List<Food> getByBusinessId(Long businessId) {

        return foodMapper.getByBusinessId(businessId);
    }
}
