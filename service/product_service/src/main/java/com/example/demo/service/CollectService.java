package com.example.demo.service;

import com.example.demo.pojo.Product;

import java.util.List;

public interface CollectService {

    //获取购物车列表
    List<Product> getCollect(int userId);

    //添加商品到购物车
    int addCollect(int userId, int productId);

    //删除购物车商品
    int deleteCollect(int userId, int productId);

    //查找是否已添加过收藏夹
    boolean isCollected(int userId, int productId);
}
