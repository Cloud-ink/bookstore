package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Carousel;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    //查询商品分类列表
    List<Category> getCategoryList();

    Product selectProductByProductId(int product_id);

    //获取轮播图列表
    List<Carousel> getCarouselList();

    //根据分类名获取商品
    List<Product> getProductListByCategoryName(String category_name);

    //根据分类id获取商品
    List<Product> getProductListByCategoryId(int category_id);

    //根据搜索获取商品
    List<Product> getProductListBySearch(String search);
}
