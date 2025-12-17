package com.example.elm_m.Exception;

/**
 * 密码错误异常
 */
public class PasswordErrorException extends BaseException {
    public PasswordErrorException() {}
    public PasswordErrorException(String message) {
        super(message);
    }
}
