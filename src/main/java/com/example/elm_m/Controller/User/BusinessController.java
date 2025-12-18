package com.example.elm_m.Controller.User;

import com.example.elm_m.Entity.Business;
import com.example.elm_m.Result.Result;
import com.example.elm_m.Service.BusinessService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/list")
    @Operation(summary = "商家列表", description = "获取商家列表")
    public Result<List<Business>> businessList () {
        log.info("商家列表");

        List<Business> businessList =  businessService.list();

        return Result.success(businessList);
    }



}
