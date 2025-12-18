package com.example.elm_m.Controller.User;

import com.example.elm_m.Entity.Category;
import com.example.elm_m.Result.Result;
import com.example.elm_m.Service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/user/category")
@RestController
@Slf4j
@Tag(name = "分类管理", description = "分类管理相关接口")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public Result<List<Category>> list() {
        log.info("获取商品的分类");

        List<Category> categoryList =  categoryService.list();
        return Result.success(categoryList);
    }

}
