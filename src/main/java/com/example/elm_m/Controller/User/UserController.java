package com.example.elm_m.Controller.User;

import com.example.elm_m.Constant.JwtClaimsConstant;
import com.example.elm_m.Context.ThreadContext;
import com.example.elm_m.DTO.PasswordDTO;
import com.example.elm_m.DTO.UserUpdateDTO;
import com.example.elm_m.DTO.UserRegisterDTO;
import com.example.elm_m.DTO.UserLoginDTO;
import com.example.elm_m.Entity.User;
import com.example.elm_m.Properties.JwtProperties;
import com.example.elm_m.Result.Result;
import com.example.elm_m.Service.UserService;
import com.example.elm_m.Utils.JwtUtil;
import com.example.elm_m.VO.UserAuthVO;
import com.example.elm_m.VO.UserLoginVO;
import com.example.elm_m.VO.UserVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/user")
@Slf4j
@Tag(name = "用户管理", description = "用户管理相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 用户登录
     * @param userLoginDTO 登录传入对象
     * @return 登录响应对象
     */
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

    /**
     * 用户登出
     * @return 登出
     */
    @PostMapping("/logout")
    @Operation(summary = "用户登出", description = "返回登出成功信息")
    public Result<String> logout() {
        log.info("退出登录");
        return Result.success("退出成功");
    }

    /**
     * 用户注册
     * @param userRegisterDTO 注册表单
     * @return 响应信息
     */
    @PostMapping("/register")
    @Operation(summary = "用户注册")
    public Result<String> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        log.info("用户注册：{}", userRegisterDTO);
        userService.register(userRegisterDTO);
        return Result.success("注册成功!");
    }

    /**
     * 获取用户的详细信息
     * @return 用户的响应对象
     */
    @GetMapping("/info")
    @Operation(summary = "获取用户信息")
    public Result<UserVO> getUserInfo() {
        log.info("获取用户信息");

        String userId = ThreadContext.getCurrentId();
        UserVO userVO = userService.getUserInfo(userId);
        return Result.success(userVO);
    }

    /**
     * 修改用户的信息
     * @param userUpdateDTO 修改的信息
     * @return 响应信息
     */
    @PutMapping("/update")
    @Operation(summary = "修改信息")
    public Result<String> updateUserInfo(@RequestBody UserUpdateDTO userUpdateDTO) {
        log.info("用户修改信息:{}", userUpdateDTO);

        String userId = ThreadContext.getCurrentId();
        userService.update(userId, userUpdateDTO);
        return Result.success("修改信息成功");
    }

    @PutMapping("/password")
    @Operation(summary = "修改密码", description = "用户修改密码")
    public Result<String> updatePassword (@RequestBody PasswordDTO passwordDTO) {
        log.info("用户修改密码:{}", passwordDTO);

        String userId = ThreadContext.getCurrentId();
        userService.updatePassword(userId, passwordDTO);

        return Result.success("修改密码成功");
    }

    @GetMapping("/auth")
    @Operation(summary = "获取验证码", description = "用户获取验证码")
    public Result<UserAuthVO> getAuthInfo() {
        log.info("获取验证码");

        UserAuthVO userAuthVO = userService.getAuthInfo();
        return Result.success(userAuthVO);
    }

}
