package com.example.elm_m.Service.Impl;

import com.example.elm_m.Constant.MessageConstant;
import com.example.elm_m.Constant.StatusConstant;
import com.example.elm_m.DTO.PasswordDTO;
import com.example.elm_m.DTO.UserRegisterDTO;
import com.example.elm_m.DTO.UserLoginDTO;
import com.example.elm_m.DTO.UserUpdateDTO;
import com.example.elm_m.Entity.User;
import com.example.elm_m.Exception.*;
import com.example.elm_m.Mapper.UserMapper;
import com.example.elm_m.Service.UserService;
import com.example.elm_m.VO.UserAuthVO;
import com.example.elm_m.VO.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 用户登录
     * @param userLoginDTO 登录提交参数
     * @return User 对象
     */
    @Override
    public User login(UserLoginDTO userLoginDTO) {

        String userId = userLoginDTO.getUserId();
        String password = userLoginDTO.getPassword();

        // 根据用户名查询数据库中的数据
        User user = userMapper.getByUserId(userId);
        // 处理各种异常情况(用户名不存在，密码不匹配，账号被锁定)
        if (user == null) {
            throw new AccountNotFoundException(MessageConstant.ACCOUNT_NOT_EXIST);
        }

        // 密码比对
        // 对前端过来的密码进行 MD5 加密处理
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        if (!password.equals(user.getPassword())) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        // 账户被锁定
        if (user.getDelTag().equals(StatusConstant.DISABLED)) {
            throw new AccountLockedException(MessageConstant.ACCOUNT_LOCKED);
        }

        // 返回实体对象
        return user;
    }

    /**
     * 用户注册
     * @param userRegisterDTO 注册提交对象
     */
    @Override
    @Transactional
    public void register(UserRegisterDTO userRegisterDTO) {

        // 不能为空
        if (userRegisterDTO == null) {
            try {
                throw new IllegalAccessException("参数不能为空");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        // 判断验证码
        String authInfo = userRegisterDTO.getAuthInfo();
        String authKey = userRegisterDTO.getAuthKey();

        String redisKey = MessageConstant.AUTH + authKey;
        String codeInRedis = (String) redisTemplate.opsForValue().get(redisKey);
        log.info("验证码：{}", codeInRedis);

        if (codeInRedis == null) {
            throw new AuthErrorException(MessageConstant.AUTH_TIMEOUT);
        }

        if (!codeInRedis.equals(authInfo)) {
            throw new AuthErrorException(MessageConstant.AUTH_ERROR);
        }

        redisTemplate.delete(redisKey);

        // 判断密码
        String userId = userRegisterDTO.getUserId();
        String password = userRegisterDTO.getPassword();
        String rePassword = userRegisterDTO.getRePassword();
        // 判断密码是否满足要求（）
        if (userId.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
            throw new ParamException(MessageConstant.PARAM_ERROR);
        }
        // 判断用户 ID 是否已存在
        User user = userMapper.getByUserId(userId);
        if (user != null) {
            throw new AccountHasExistedException(MessageConstant.ACCOUNT_HAS_EXIST);
        }
        // 判断两次密码是否相同
        if (!password.equals(rePassword)) {
            throw new PasswordNotSameException(MessageConstant.PASSWORD_NOT_SAME);
        }

        User user1 = new User();
        BeanUtils.copyProperties(userRegisterDTO, user1);

        // 密码加密
        user1.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user1.setDelTag(StatusConstant.ENABLED);
        user1.setUserImg(MessageConstant.DEFAULT_IMG);

        userMapper.insert(user1);
    }

    @Override
    public UserVO getUserInfo(String userId) {
        User user = userMapper.getByUserId(userId);

        return UserVO.builder()
                .userId(userId)
                .userName(user.getUserName())
                .userImg(user.getUserImg())
                .userSex(user.getUserSex())
                .build();
    }

    /**
     * 修改用户的信息
     * @param userUpdateDTO 用户修改信息dto
     */
    @Override
    public void update(String userId, UserUpdateDTO userUpdateDTO) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO, user);
        user.setUserId(userId);

        userMapper.update(user);

    }

    @Override
    public void updatePassword(String userId, PasswordDTO passwordDTO) {
        String password = passwordDTO.getPassword();
        String newPassword = passwordDTO.getNewPassword();
        String reNewPassword = passwordDTO.getReNewPassword();

        User user = userMapper.getByUserId(userId);
        String oldPassword = user.getPassword();

        password = DigestUtils.md5DigestAsHex(password.getBytes());
        // 判断旧密码是否正确
        if (!oldPassword.equals(password)) {
            throw new PasswordErrorException(MessageConstant.PASSWORD_ERROR);
        }

        // 判断两次新密码是否相同
        if (!newPassword.equals(reNewPassword)) {
            throw new PasswordNotSameException(MessageConstant.PASSWORD_NOT_SAME);
        }

        // 新密码加密后存入数据库
        newPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        User user1 = new User();
        user1.setUserId(userId);
        user1.setPassword(newPassword);
        userMapper.update(user1);

    }

    /**
     * 用户获取验证码
     * @return 验证码
     */
    @Override
    public UserAuthVO getAuthInfo() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            code.append((int) (Math.random() * 10));
        }
        String authInfo = code.toString();
        String key = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(MessageConstant.AUTH + key, authInfo, 60, TimeUnit.SECONDS);


        return UserAuthVO.builder()
                .authInfo(authInfo)
                .authKey(key)
                .build();
    }
}
