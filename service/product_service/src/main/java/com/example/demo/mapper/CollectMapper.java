package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Collect;
import com.example.demo.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface CollectMapper extends BaseMapper<Collect> {

    //获取购物车列表
    List<Product> getCollect(int userId);

    int deleteByMap(HashMap<String, Integer> map);
}
