package com.example.elm_m.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class ShoppingCartDTO implements Serializable {
    private Long foodId;
    private Long setMealId;
    private String flavor;
    private Long businessId;

}
