package com.example.elm_m.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Data
@Schema(description = "用户修改请求对象")
public class UserUpdateDTO implements Serializable {

    @Schema(description = "姓名",example = "张三")
    private String userName;

    @Schema(description = "性别",example = "1")
    private Integer userSex;

    @Schema(description = "头像URL", example = "https://rein-aito.oss-cn-beijing.aliyuncs.com/xxx.jpg")
    private String userImg;

}
