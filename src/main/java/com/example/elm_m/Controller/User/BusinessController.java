package com.example.elm_m.Controller.User;

import com.example.elm_m.Entity.Business;
import com.example.elm_m.Entity.FoodType;
import com.example.elm_m.Result.Result;
import com.example.elm_m.Service.BusinessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/business")
@Slf4j
@Tag(name = "商家管理", description = "商家管理相关接口")
public class BusinessController {

    @Autowired
    BusinessService businessService;

    /**
     * 获取商家列表
     * @return 商家列表
     */
    @GetMapping("/list")
    @Operation(summary = "商家列表", description = "获取商家列表")
    public Result<List<Business>> businessList () {
        log.info("商家列表");

        List<Business> businessList =  businessService.list();

        return Result.success(businessList);
    }

    /**
     * 获取特定种类的商家列表
     * @param typeId 分类id
     * @return 商家列表
     */
    @GetMapping("/list/{typeId}")
    @Operation(summary = "特定商家列表", description = "食物类别分类的商家列表")
    public Result<List<Business>> getByFoodType(@PathVariable Long typeId) {
        log.info("特定分类的商家列表");

        List<Business> businessList = businessService.getByFoodType(typeId);
        return Result.success(businessList);
    }

    /**
     * 根据商家 id 获取商家
     * @param businessId 商家id
     * @return 商家
     */
    @GetMapping("/{businessId}")
    @Operation(summary = "获取商家")
    public Result<Business> getByBusinessId(@PathVariable Long businessId) {
        log.info("获取商家：{}", businessId);

        Business business = businessService.getByBusinessId(businessId);
        return Result.success(business);
    }

}
