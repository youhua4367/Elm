package com.example.elm_m.Controller.User;

import com.example.elm_m.DTO.OrderSubmitDTO;
import com.example.elm_m.Entity.OrderDetail;
import com.example.elm_m.Entity.Orders;
import com.example.elm_m.Result.Result;
import com.example.elm_m.Service.OrderService;
import com.example.elm_m.VO.OrderSubmitVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user/order")
@Tag(name = "订单管理", description = "用户订单相关接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 提交订单
     * @param orderSubmitDTO 订单提交对象
     * @return 订单响应对象
     */
    @PostMapping("/submit")
    @Operation(summary = "用户下单")
    public Result<OrderSubmitVO> submit(@RequestBody OrderSubmitDTO orderSubmitDTO) {
        log.info("用户下单:{}", orderSubmitDTO);

        OrderSubmitVO orderSubmitVO = orderService.submitOrder(orderSubmitDTO);
        return Result.success(orderSubmitVO);
    }

    /**
     * 获取历史订单列表
     * @return 历史订单列表
     */
    @GetMapping("/history")
    @Operation(summary = "获取历史订单")
    public Result<List<Orders>> getOrders() {
        log.info("获取历史订单");

        List<Orders> ordersList = orderService.getOrders();
        return Result.success(ordersList);
    }

    /**
     * 获取历史订单详情
     * @param id 订单号
     * @return 订单详情列表
     */
    @GetMapping("/orderDetail/{id}")
    @Operation(summary = "查看订单详情")
    public Result<List<OrderDetail>> getOrderDetails(@PathVariable Long id) {
        log.info("查看订单详情:{}",id);

        List<OrderDetail> orderDetailList = orderService.getOrderDetail(id);
        return Result.success(orderDetailList);
    }

    /**
     * 取消订单
     * @param id 订单id
     * @return 成功标志
     */
    @PutMapping("/cancel/{id}")
    @Operation(summary = "取消订单")
    public Result<String> cancelOrder(Long id) {
        log.info("取消订单:{}", id);

        orderService.CancelById(id);
        return Result.success("取消订单成功");
    }

    /**
     * 再来一单
     * @param id 订单id
     * @return 成功标志
     */
    @PostMapping("/repeat/{id}")
    @Operation(summary = "再来一单")
    public Result<String> repeatOne(@PathVariable Long id) {
        log.info("再来一单:{}", id);

        orderService.repeatOne(id);
        return Result.success("再来一单成功");
    }
}
