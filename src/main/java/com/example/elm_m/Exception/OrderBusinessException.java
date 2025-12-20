package com.example.elm_m.Exception;

/**
 * 订单异常
 */
public class OrderBusinessException extends BaseException {
    public OrderBusinessException () {}
    public OrderBusinessException(String message) {
        super(message);
    }
}
