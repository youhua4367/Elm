package com.example.elm_m.Service.Impl;

import com.example.elm_m.Context.ThreadContext;
import com.example.elm_m.DTO.ShoppingCartDTO;
import com.example.elm_m.Entity.Cart;
import com.example.elm_m.Entity.Food;
import com.example.elm_m.Entity.SetMeal;
import com.example.elm_m.Mapper.CartMapper;
import com.example.elm_m.Mapper.FoodMapper;
import com.example.elm_m.Mapper.SetMealMapper;
import com.example.elm_m.Service.ShoppingCartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private FoodMapper foodMapper;

    @Autowired
    private SetMealMapper setMealMapper;

    /**
     * 添加到购物车
     * @param shoppingCartDTO 购物车传递对象
     */
    @Override
    public void addShoppingCart(ShoppingCartDTO shoppingCartDTO) {
        // 判断当前加入购物车的数据是否存在
        Cart cart = new Cart();

        // 拷贝了 食物或者套餐的 id ， 口味和商家 id
        BeanUtils.copyProperties(shoppingCartDTO, cart);
        String userId = ThreadContext.getCurrentId();
        // 设置了用户的 id
        cart.setUserId(userId);

        List<Cart> cartList = cartMapper.list(cart);
        // 如果存在数量+1
        if (cartList != null && !cartList.isEmpty()) {
            Cart cart1 = cartList.get(0);
            cart1.setQuantity(cart1.getQuantity() + 1);
            cartMapper.updateQuantityById(cart1);
        } else {
            // 如果不存在则插入

            Long foodId = shoppingCartDTO.getFoodId();
            if (foodId != null) {
                //菜品表
                Food food = foodMapper.getFoodById(foodId);
                cart.setName(food.getFoodName());
                cart.setAmount(food.getFoodPrice());
                cart.setImg(food.getFoodImg());

            } else {
                // 套餐表
                Long setMealId = shoppingCartDTO.getSetMealId();
                SetMeal setMeal = setMealMapper.getSetMealById(setMealId);
                cart.setSetMealId(setMeal.getSetMealId());
                cart.setAmount(setMeal.getPrice());
                cart.setImg(setMeal.getImg());
            }
            cart.setQuantity(1);
            cartMapper.insert(cart);
        }
    }

    /**
     * 获取购物车
     * @return 购物车列表
     */
    @Override
    public List<Cart> get() {
        String userId = ThreadContext.getCurrentId();
        Cart cart = Cart.builder().userId(userId).build();
        return cartMapper.list(cart);
    }

    /**
     * 清空购物车
     */
    @Override
    public void cleanCart() {
        String userId = ThreadContext.getCurrentId();
        cartMapper.deleteById(userId);
    }

    @Override
    public void subCart(ShoppingCartDTO shoppingCartDTO) {
        // 查询到这一项商品
        String userId = ThreadContext.getCurrentId();
        Cart cart = Cart.builder().userId(userId).build();
        BeanUtils.copyProperties(shoppingCartDTO, cart);

        List<Cart> cartList = cartMapper.list(cart);
        if (cartList != null && !cartList.isEmpty()) {
            Cart cart1 = cartList.get(0);
            // 获取该商品的数量
            Integer quantity = cart1.getQuantity();

            // 商品数量为 1 则删除这条商品记录
            if (quantity == 1) {
                cartMapper.deleteByCartId(cart1.getCartId());
            } else {
                // 商品数量大于 1 , 则商品的数量减 1
                cart1.setQuantity(quantity - 1);
                cartMapper.updateQuantityById(cart1);
            }
        }
    }
}
