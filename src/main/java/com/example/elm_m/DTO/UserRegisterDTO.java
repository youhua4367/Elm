package com.example.elm_m.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "用户注册请求对象")
public class UserRegisterDTO implements Serializable {
    private String userId;
    private String password;
    // 确认密码
    private String rePassword;

    @Schema(description = "验证码", example = "123456")
    private String authInfo;

    @Schema(description = "随机key")
    private String authKey;

}
