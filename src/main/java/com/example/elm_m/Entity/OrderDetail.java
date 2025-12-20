package com.example.elm_m.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetail implements Serializable {
    // 订单明细 id（主键）
    private Long odId;
    private Long orderId;
    private Long foodId;
    private Long setMealId;
    private Integer quantity;

    private String name;
    private String img;
    private BigDecimal amount;
    private String flavor;
    private Long businessId;
}
