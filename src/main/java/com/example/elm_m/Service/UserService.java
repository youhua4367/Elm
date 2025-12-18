package com.example.elm_m.Service;

import com.example.elm_m.DTO.PasswordDTO;
import com.example.elm_m.DTO.UserRegisterDTO;
import com.example.elm_m.DTO.UserLoginDTO;
import com.example.elm_m.DTO.UserUpdateDTO;
import com.example.elm_m.Entity.User;
import com.example.elm_m.VO.UserVO;

public interface UserService {
    User login(UserLoginDTO userLoginDTO);

    void register(UserRegisterDTO userRegisterDTO);

    UserVO getUserInfo(String userId);

    void update(String userId, UserUpdateDTO userUpdateDTO);

    void updatePassword(String userId, PasswordDTO passwordDTO);
}
