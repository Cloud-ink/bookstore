package com.example.demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Cart;
import com.example.demo.pojo.vo.CartVo;

import java.util.List;

public interface CartService {
    //获取购物车列表
    List<CartVo> getCartList(int userId);

    //添加购物车
    int addCart(int userId, int productId);

    //更新购物车
    int updateCart(int userId, int productId, int cartNum);

    //删除购物车
    int deleteCart(int userId, int productId);

    //是否已存在
    boolean isCart(int userId, int productId);

    //批量删除
    boolean deleteCarts(List<Integer> idList);

}
