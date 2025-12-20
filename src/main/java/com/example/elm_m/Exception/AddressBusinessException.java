package com.example.elm_m.Exception;

/**
 * 地址簿为空异常
 */
public class AddressBusinessException extends BaseException {
    public AddressBusinessException() {}

    public AddressBusinessException(String message) {
        super(message);
    }
}
