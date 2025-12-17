package com.example.elm_m.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "用户登录响应对象")
public class UserLoginVO {

    @Schema(description = "用户id", example = "1123324")
    private String userId;

    @Schema(description = "用户姓名", example = "张三")
    private String userName;

    @Schema(description = "jwt令牌")
    private String token;
}
