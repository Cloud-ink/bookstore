package com.example.demo.service;

import com.example.demo.pojo.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrder(int user_id);
    //添加订单
    int addOrder(int user_id,int product_id,int product_num,int product_price);
}