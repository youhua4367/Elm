package com.example.elm_m.DTO;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderSubmitDTO implements Serializable {
    // 商家 id
    private Long businessId;

    // 总金额
    private BigDecimal orderTotal;
    // 送货地址的 id
    private Long addressId;
    // 备注
    private String remark;
    // 打包费
    private BigDecimal packAmount;
}
