package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.CollectMapper;
import com.example.demo.pojo.Collect;
import com.example.demo.pojo.Product;
import com.example.demo.service.CollectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectMapper collectMapper;

    @Override
    @ApiOperation("获取购物车列表")
    public List<Product> getCollect(int userId) {
        return collectMapper.getCollect(userId);
    }

    @Override
    @ApiOperation("添加购物车")
    public int addCollect(int userId, int productId) {
        Collect collect = new Collect();
        collect.setUserId(userId);
        collect.setProductId(productId);
        return collectMapper.insert(collect);
    }

    @Override
    @ApiOperation("删除购物车")
    public int deleteCollect(int userId, int productId) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("user_id", userId);
        map.put("product_id", productId);
        return collectMapper.deleteByMap(map);
    }

    @Override
    @ApiOperation("查找是否已添加收藏夹")
    public boolean isCollected(int userId, int productId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("product_id", productId);
        Collect collect = new Collect();
        collect = collectMapper.selectOne(queryWrapper);
        Boolean isCollected = true;
        if(collect == null) {
            isCollected = false;
        }
        return isCollected;
    }
}
