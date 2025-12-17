package com.example.elm_m.Controller.User;

import com.example.elm_m.Constant.JwtClaimsConstant;
import com.example.elm_m.DTO.UserLoginDTO;
import com.example.elm_m.Entity.User;
import com.example.elm_m.Properties.JwtProperties;
import com.example.elm_m.Result.Result;
import com.example.elm_m.Service.UserService;
import com.example.elm_m.Utils.JwtUtil;
import com.example.elm_m.VO.UserLoginVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
@Tag(name = "用户管理", description = "用户管理相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    @Operation(summary = "用户登录", description = "登录成功后，返回 token")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录：{}", userLoginDTO);

        User user = userService.login(userLoginDTO);

        // 登录成功后，返回 jwt 令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getUserId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims
        );

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .userId(user.getUserId())
                .token(token)
                .userName(user.getUserName())
                .build();

        return Result.success(userLoginVO);
    }

}
