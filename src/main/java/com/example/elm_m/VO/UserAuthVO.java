package com.example.elm_m.VO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "用户验证码对象")
public class UserAuthVO {

    @Schema(description = "验证码", example = "123456")
    private String authInfo;

    @Schema(description = "随机key")
    private String authKey;
}
