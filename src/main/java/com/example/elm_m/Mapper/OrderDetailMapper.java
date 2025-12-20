package com.example.elm_m.Mapper;

import com.example.elm_m.Entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    void insertBatch(List<OrderDetail> orderDetailList);

    @Select("select * from order_detail where orderId = #{id}")
    List<OrderDetail> getDetailByOrderId(Long id);
}
