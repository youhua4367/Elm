package com.example.elm_m.Mapper;

import com.example.elm_m.Entity.Business;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BusinessMapper {

    @Select("select * from business")
    List<Business> getBusinessList();

    @Select("select * from business where orderTypeId = #{typeId}")
    List<Business> getByFoodType(Long typeId);

    @Select("select * from business where businessId = #{businessId}")
    Business getByBusinessId(Long businessId);
}
