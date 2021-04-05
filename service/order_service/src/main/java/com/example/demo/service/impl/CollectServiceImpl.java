package com.example.demo.service.impl;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.pojo.Product;
import com.example.demo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Product> getCollectByUserId(int user_id) {
        return null;
    }

    @Override
    public int addCollectByUserId(int user_id, int product_id) {
        return 0;
    }

    @Override
    public int deleteCollectByUserId(int user_id, int product_id) {
        return 0;
    }
}
