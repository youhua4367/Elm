package com.example.elm_m.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodType implements Serializable {
    private Long typeId;
    private String typeName;
    private String typeImg;
    private Integer sortOrder;
    private Integer isEnabled;
    private LocalDate createTime;
}
