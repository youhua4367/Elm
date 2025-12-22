package com.example.elm_m.Controller.User;

import com.example.elm_m.DTO.ShoppingCartDTO;
import com.example.elm_m.Entity.Cart;
import com.example.elm_m.Result.Result;
import com.example.elm_m.Service.CategoryService;
import com.example.elm_m.Service.ShoppingCartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/cart")
@Slf4j
@Tag(name = "购物车管理", description = "购物车管理接口")
public class CartController {

    @Autowired
    private ShoppingCartService shoppingCartService;


    /**
     * 商品添加到购物车
     * @param shoppingCartDTO 购物车接受对象
     * @return 成功标志
     */
    @PostMapping("/add")
    @Operation(summary = "添加到购物车")
    public Result<String> add(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("shoppingCartDTO:{}", shoppingCartDTO);
        shoppingCartService.addShoppingCart(shoppingCartDTO);
        return Result.success("添加购物车成功");
    }

    /**
     * 获取所有的购物车
     * @return 购物车列表
     */
    @GetMapping("/get")
    @Operation(summary = "获取购物车")
    public Result<List<Cart>> get() {
        log.info("获取购物车");
        List<Cart> cartList = shoppingCartService.get();
        return Result.success(cartList);
    }

    /**
     * 清空购物车
     * @return 成功标志
     */
    @DeleteMapping("/clean")
    @Operation(summary = "清空购物车")
    public Result<String> clean() {
        log.info("清空购物车");

        shoppingCartService.cleanCart();
        return Result.success("购物车已清空");
    }

    @PostMapping("/sub")
    @Operation(summary = "去除一项商品")
    public Result<String> sub(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        log.info("删除商品:{}", shoppingCartDTO);

        shoppingCartService.subCart(shoppingCartDTO);
        return Result.success("去除商品成功!");
    }
}
