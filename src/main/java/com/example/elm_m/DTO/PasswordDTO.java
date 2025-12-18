package com.example.elm_m.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "用户修改密码请求对象")
public class PasswordDTO implements Serializable {

    @Schema(description = "旧密码",example = "123456")
    private String password;

    @Schema(description = "新密码",example = "123456")
    private String newPassword;

    @Schema(description = "再次输入新密码",example = "123456")
    private String reNewPassword;
}
