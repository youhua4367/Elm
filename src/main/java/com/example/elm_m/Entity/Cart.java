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
public class Cart implements Serializable {

    private Long cartId;
    private Long foodId;
    private Long businessId;
    private String userId;
    private Long setMealId;

    // 数量
    private Integer quantity;
    // 口味
    private String flavor;
    // 图片
    private String img;
    // 价钱
    private BigDecimal amount;
    // 名称
    private String name;

}
