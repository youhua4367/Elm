package com.example.elm_m.Exception;

/**
 * 购物车为空异常
 */
public class CartBusinessException extends BaseException {
    public CartBusinessException () {}
    public CartBusinessException(String message) {
        super(message);
    }
}
