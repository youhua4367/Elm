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
public class Cart implements Serializable {

    private Long cartId;
    private Long foodId;
    private Long businessId;
    private String userId;
    private Integer quantity;
}
