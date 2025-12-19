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
public class Address implements Serializable {
    private Long addressId;
    // 联系人姓名
    private String userId;

    private String name;
    private String phone;
    // 1表示男，0表示女
    private Integer sex;

    // 省级区划编号
    private String provinceCode;

    // 市级区划编号
    private String cityCode;

    // 区级区划编号
    private String districtCode;

    // 省级名称
    private String provinceName;

    // 市级名称
    private String cityName;

    // 区级名称
    private String districtName;

    // 详细地址
    private String detail;

    //标签（家，学校等）
    private String label;

    // 是否默认，0为否，1为是
    private Integer isDefault;


}
