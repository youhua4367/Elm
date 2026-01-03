package com.example.elm_m.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders implements Serializable {

    /**
     * 订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消
     */
    public static final Integer PENDING_PAYMENT = 1;
    public static final Integer TO_BE_CONFIRMED = 2;
    public static final Integer CONFIRMED = 3;
    public static final Integer DELIVERY_IN_PROGRESS = 4;
    public static final Integer COMPLETED = 5;
    public static final Integer CANCELLED = 6;

    /**
     * 支付状态 0未支付 1已支付 2退款
     */
    public static final Integer PAID = 1;
    public static final Integer UN_PAID = 0;

    private Long orderId;
    private String userId;
    private Long businessId;

    private LocalDateTime orderTime;
    private BigDecimal orderTotal;
    // 送货地址的 id
    private Long addressId;

    // 支付状态，0表示未支付，1表示已支付
    private Integer payStatus;

    // 备注
    private String remark;
    // 打包费
    private BigDecimal packAmount;

    //订单状态订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消 7退款
    private Integer orderStatus;

    // 送达时间
    private LocalDateTime deliveryTime;

    // 取消时间
    private LocalDateTime cancelTime;

    // 订单号
    private String number;


}
