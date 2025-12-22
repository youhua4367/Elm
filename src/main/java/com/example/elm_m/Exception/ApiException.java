package com.example.elm_m.Exception;

/**
 * 调用api错误
 */
public class ApiException extends BaseException {
    public ApiException () {}

    public ApiException(String message) {
        super(message);
    }
}
