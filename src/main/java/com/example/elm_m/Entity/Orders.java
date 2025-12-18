package com.example.elm_m.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders implements Serializable {
    private Long orderId;
    private String userId;
    private Long businessId;
    private LocalDate orderDate;
    private BigDecimal orderTotal;
    // 送货地址的 id
    private Long daId;
    // 订单状态，0表示未支付，1表示已支付
    private Integer orderState;
}
