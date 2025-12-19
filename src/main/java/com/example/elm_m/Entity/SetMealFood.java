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
public class SetMealFood implements Serializable {

    private Long id;
    private Long setMealId;
    private Long foodId;

    // 菜品名称
    private String name;

    // 价格
    private BigDecimal price;

    // 份数
    private Integer count;
}
