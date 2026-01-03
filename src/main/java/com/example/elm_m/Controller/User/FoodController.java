package com.example.elm_m.Controller.User;

import com.example.elm_m.Entity.Food;
import com.example.elm_m.Mapper.FoodMapper;
import com.example.elm_m.Result.Result;
import com.example.elm_m.Service.FoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/food")
@Tag(name = "食品管理", description = "食物相关接口")
@Slf4j
public class FoodController {

    @Autowired
    private FoodService foodService;

    /**
     * 获取食物列表
     * @return 食物列表
     */
    @GetMapping("/{businessId}")
    @Operation(summary = "获取食物列表")
    @Cacheable(cacheNames = "food", key = "#businessId")
    public Result<List<Food>> getByBusinessId(@PathVariable Long businessId) {
        log.info("获取食物列表：{}", businessId);

        List<Food> foodList = foodService.getByBusinessId(businessId);
        return Result.success(foodList);
    }
}
