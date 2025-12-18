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
public class User implements Serializable {

    private String userId;
    private String userName;
    private String password;
    private Integer userSex;
    private String userImg;
    // 删除标记，1表示正常，0表示不正常
    private Integer delTag;
}
