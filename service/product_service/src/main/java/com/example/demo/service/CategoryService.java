package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CategoryService {
    //获取所有的分类
    List<Category> listCategoryies();

    //获取热门商品
    List<Product> getPromosList(String categoryName);

    @ApiParam("根据分类获取商品并分页")
    IPage<Product> selectPage(Page<Product> page, QueryWrapper queryWrapper);

    //根据分类获取商品
    List<Product> getProductByCategory(int categoryId, int currentPage, int pageSize);
}
