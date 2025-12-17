package com.example.elm_m.Service;

import com.example.elm_m.DTO.UserLoginDTO;
import com.example.elm_m.Entity.User;

public interface UserService {
    User login(UserLoginDTO userLoginDTO);
}
