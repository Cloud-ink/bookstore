package com.example.demo.service.impl;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.pojo.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> getAllOrder(int user_id) {
        return orderMapper.getAllOrder(user_id);
    }

    @Override
    public int addOrder(int user_id, int product_id, int product_num, int product_price) {
        return orderMapper.addOrder(user_id,product_id,product_num,product_price);
    }
}