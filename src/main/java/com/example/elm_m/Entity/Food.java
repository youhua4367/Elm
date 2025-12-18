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
public class Food implements Serializable {

    private Long foodId;
    private String foodName;
    private String foodExplain;
    private String foodImg;
    private BigDecimal foodPrice;
    private Long businessId;
    // 备注
    private String remarks;
}
