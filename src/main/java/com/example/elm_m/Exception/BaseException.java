package com.example.elm_m.Exception;

/**
 * 业务异常
 */
public class BaseException extends RuntimeException {
    public BaseException() {

    }

    public BaseException(String message) {
        super(message);
    }
}
