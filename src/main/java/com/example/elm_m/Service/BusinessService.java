package com.example.elm_m.Service;

import com.example.elm_m.Entity.Business;

import java.util.List;

public interface BusinessService {
    List<Business> list();

    List<Business> getByFoodType(Long typeId);

    Business getByBusinessId(Long businessId);
}
