package com.example.elm_m.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category implements Serializable {

    // 分类 ID
    private Long categoryId;

    // 分类名称
    private String categoryName;

    // 分类类别，1表示菜品，2表示套餐
    private Integer type;

    // 顺序
    private Integer sort;

    // 状态，1表示启用，0表示禁用
    private Integer status;

    // 商家id
    private Long businessId;
}
