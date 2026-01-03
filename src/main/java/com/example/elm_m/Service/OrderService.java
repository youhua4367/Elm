package com.example.elm_m.Service;

import com.example.elm_m.DTO.OrderSubmitDTO;
import com.example.elm_m.Entity.OrderDetail;
import com.example.elm_m.Entity.Orders;
import com.example.elm_m.VO.OrderSubmitVO;

import java.util.List;

public interface OrderService {
    OrderSubmitVO submitOrder(OrderSubmitDTO orderSubmitDTO);

    List<Orders> getOrders();

    List<OrderDetail> getOrderDetail(Long id);

    void CancelById(Long id);

    void repeatOne(Long id);

    void payOrder(Long id);
}
