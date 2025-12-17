package com.example.elm_m.Exception;

/**
 * 账户被锁定异常
 */
public class AccountLockedException extends BaseException {
    public AccountLockedException() {

    }

    public AccountLockedException(String message) {
        super(message);
    }
}
