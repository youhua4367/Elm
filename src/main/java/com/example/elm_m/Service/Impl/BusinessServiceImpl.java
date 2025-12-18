package com.example.elm_m.Service.Impl;

import com.example.elm_m.Entity.Business;
import com.example.elm_m.Mapper.BusinessMapper;
import com.example.elm_m.Service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private BusinessMapper businessMapper;

    /**
     * 商家列表内容
     * @return 商家列表
     */
    @Override
    public List<Business> list() {

        return businessMapper.getBusinessList();
    }
}
