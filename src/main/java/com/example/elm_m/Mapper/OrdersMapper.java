package com.example.elm_m.Mapper;

import com.example.elm_m.Entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrdersMapper {
    void insert(Orders orders);

    @Select("select * from orders where userId = #{userId}")
    List<Orders> getOrdersByUserId(String userId);

    @Select("select * from orders where orderId = #{id}")
    Orders getById(Long id);

    void update(Orders orders);

    @Update("""
    update orders
    set payStatus = #{payStatus},
        orderStatus = #{orderStatus}
    where orderId = #{id}
""")
    void setStatus(
            @Param("id") Long id,
            @Param("payStatus") Integer payStatus,
            @Param("orderStatus") Integer orderStatus
    );

}
