package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.exception.BookStoreException;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import com.example.demo.result.ResultCodeEnum;
import com.example.demo.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    //获取分类列表
    public List<Category> listCategoryies() {
        List<Category> categoryList = categoryMapper.selectList(null);
        return categoryList;
    }

    //获取首页分类商品
    @Override
    public List<Product> getPromosList(String categoryName) {
        List<Product> promoProducts = categoryMapper.getProductListByCategoryName(categoryName);
        return promoProducts;
    }

    @Override
    public IPage<Product> selectPage(Page<Product> page, QueryWrapper queryWrapper) {
        return null;
    }

//    @ApiOperation("根据分类获取商品并分页")
//    @Override
//    public IPage<Product> selectPage(Page<Product> page, QueryWrapper queryWrapper) {
//        return categoryMapper.selectPage(page,queryWrapper);
//    }

    //根据分类获取商品
    @Override
    public List<Product> getProductByCategory(int categoryId, int currentPage, int pageSize) {
        if(StringUtils.isEmpty(categoryId) || StringUtils.isEmpty(currentPage) || StringUtils.isEmpty(pageSize)) {
            throw new BookStoreException(ResultCodeEnum.FAILED);
        }
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("category_id", categoryId);
        List<Product> products = categoryMapper.selectList(queryWrapper);
        System.out.println(products);
        return products;

    }
}
