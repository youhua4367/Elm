package com.example.elm_m.Exception;

/**
 * 账户不存在异常
 */
public class AccountNotFoundException extends BaseException {
    public AccountNotFoundException() {

    }

    public AccountNotFoundException(String message) {
        super(message);
    }
}
