package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Carousel;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import com.example.demo.result.VoPage;
import io.swagger.annotations.ApiParam;

import java.util.List;

public interface ProductService {

    @ApiParam("分页")
    IPage<Product> selectPage(Page<Product> page, QueryWrapper queryWrapper);

    List<Category> getCategoryList();

    @ApiParam("根据ID获取商品详情")
    Product getProductByProductId(int product_id, QueryWrapper<Product> queryWrapper);

    @ApiParam("获取轮播图列表")
    List<Carousel> getCarouselList();

    //根据分类id获取商品
    VoPage getProductListByCategoryId(int category_id);

    //根据搜索获取商品
    VoPage getProductListBySearch(String search);


}
