package com.example.elm_m.Controller.User;
import com.example.elm_m.Entity.FoodType;
import com.example.elm_m.Result.Result;
import com.example.elm_m.Service.FoodTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user/type")
@Tag(name = "类型管理", description = "类型管理相关接口")
public class FoodTypeController {

    @Autowired
    private FoodTypeService foodTypeService;

    /**
     * 获取食物类别
     * @return 食物类别列表
     */
    @GetMapping()
    @Operation(summary = "获取类型种类")
    public Result<List<FoodType>> getFoodType() {
        log.info("获取食物分类");

        List<FoodType> foodTypeList = foodTypeService.getFoodType();
        return Result.success(foodTypeList);
    }
}
