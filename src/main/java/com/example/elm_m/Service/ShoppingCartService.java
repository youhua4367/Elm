package com.example.elm_m.Service;

import com.example.elm_m.DTO.ShoppingCartDTO;
import com.example.elm_m.Entity.Cart;

import java.util.List;

public interface ShoppingCartService {
    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    List<Cart> get();

    void cleanCart();

    void subCart(ShoppingCartDTO shoppingCartDTO);
}
