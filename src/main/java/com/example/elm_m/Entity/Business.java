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
public class Business implements Serializable {

    private Long businessId;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private String businessImg;
    // 点餐分类
    private Long orderTypeId;
    // 起送费
    private BigDecimal starPrice;
    // 配送费
    private BigDecimal deliveryPrice;
    // 备注
    private String remarks;
}
