package com.example.elm_m.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "用户信息响应对象")
public class UserVO implements Serializable {
    private String userId;
    private String userName;
    private Integer userSex;
    private String userImg;

}
