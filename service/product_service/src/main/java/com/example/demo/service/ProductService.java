package com.example.demo.service;

import com.example.demo.pojo.Carousel;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import com.example.demo.result.VoPage;

import java.util.List;

public interface ProductService {
    public VoPage searchProduct(int pageNo, int limit, String idSorted);
    //前台
    //查询所有商品
    VoPage searchProduct(int pageNo, int limit);
    //查询商品分类列表
    List<Category> getCategoryList();

    Product getProductByProductId(int product_id);
    //获取轮播图列表
    List<Carousel> getCarouselList();
    //根据分类名获取商品
    List<Product> getProductListByCategoryName(String category_name);
    //根据分类id获取商品
    VoPage getProductListByCategoryId(int category_id);
    //根据搜索获取商品
    VoPage getProductListBySearch(String search);
}
