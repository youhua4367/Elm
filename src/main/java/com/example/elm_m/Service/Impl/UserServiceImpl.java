package com.example.elm_m.Service.Impl;

import com.example.elm_m.Constant.MessageConstant;
import com.example.elm_m.Constant.StatusConstant;
import com.example.elm_m.DTO.UserLoginDTO;
import com.example.elm_m.Entity.User;
import com.example.elm_m.Exception.AccountLockedException;
import com.example.elm_m.Exception.AccountNotFoundException;
import com.example.elm_m.Exception.PasswordErrorException;
import com.example.elm_m.Mapper.UserMapper;
import com.example.elm_m.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


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
}
