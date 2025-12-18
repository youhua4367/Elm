package com.example.elm_m.Exception;

/**
 * 两次密码不相同异常
 */
public class PasswordNotSameException extends BaseException {
    public PasswordNotSameException() {}
    public PasswordNotSameException(String message) {
        super(message);
    }
}
