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
public class DeliveryAddress implements Serializable {
    private Long daId;
    // 联系人姓名
    private String contactName;
    // 1表示男，0表示女
    private Integer contactSex;
    private String contactTel;
    private String address;
    private String userId;
}
