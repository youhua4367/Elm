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
public class SetMeal implements Serializable {
    private Long setMealId;
    private Long categoryId;
    private String setMealName;
    private BigDecimal price;
    private Integer status;
    private String description;
    private String img;
}
