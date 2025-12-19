package com.example.elm_m.Service.Impl;

import com.example.elm_m.Entity.Cart;
import com.example.elm_m.Entity.Category;
import com.example.elm_m.Mapper.CategoryMapper;
import com.example.elm_m.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        return categoryMapper.getCategoryList();
    }

}
