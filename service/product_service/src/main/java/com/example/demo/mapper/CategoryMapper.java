package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    //获取轮播图列表
    List<Product> getProductListByCategoryName(String categoryName);
}
