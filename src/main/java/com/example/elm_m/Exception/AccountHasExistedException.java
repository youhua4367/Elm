package com.example.elm_m.Exception;

/**
 * 账户已存在
 */
public class AccountHasExistedException extends BaseException {
    public AccountHasExistedException() {

    }
    public AccountHasExistedException(String message) {
        super(message);
    }
}
