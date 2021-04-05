package com.example.demo.service;

public interface ShoppingCartService {
    List<ShoppingCart> getShoppingCart(int user_id);
    //删除购物车
    int deleteShoppingCart(int user_id,int product_id);
    //添加购物车
    int addShoppingCart(int user_id,int product_id);
    //更新购物车
    int updateShoppingCart(int user_id,int product_id,int cart_num);
}
