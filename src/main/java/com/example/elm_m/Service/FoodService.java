package com.example.elm_m.Service;

import com.example.elm_m.Entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> getByBusinessId(Long businessId);
}
