package com.example.demo.service;

import com.example.demo.pojo.Product;

import java.util.List;

public interface CollectService {
    //获取收藏列表
    List<Product> getCollectByUserId(int user_id);
    //添加收藏
    int addCollectByUserId(int user_id,int product_id);
    //删除收藏
    int deleteCollectByUserId(int user_id,int product_id);

}
