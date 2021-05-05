package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.pojo.Carousel;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import com.example.demo.result.VoPage;
import com.example.demo.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @ApiOperation("分页")
    @Override
    public IPage<Product> selectPage(Page<Product> page, QueryWrapper queryWrapper) {
        return productMapper.selectPage(page,queryWrapper);
    }

    @Override
    public List<Category> getCategoryList() {
        return null;
    }

    @ApiOperation("根据ID获取商品列表")
    @Override
    public Product getProductByProductId(int product_id, QueryWrapper<Product> queryWrapper) {
        System.out.println(productMapper.selectOne(queryWrapper));
        return productMapper.selectOne(queryWrapper);
    }

    @Override
    public List<Carousel> getCarouselList() {
        return null;
    }

    @Override
    public VoPage getProductListByCategoryId(int category_id) {
        return null;
    }

    @Override
    public VoPage getProductListBySearch(String search) {
        return null;
    }

//    @Override
//    public VoPage searchEmployees(int pageNo, int limit, String idSorted) {
//        VoPage page = null;
//
//        List<VoEmployee> userList = new ArrayList<>();
//        userList.addAll(this.idMaps.values());
//        if(idSorted != null && idSorted.startsWith("-")){
//            Collections.reverse(userList);
//        }
//        int total = userList.size();
//        int maxPageNo = userList.size()%limit == 0? userList.size()/limit:userList.size()/limit + 1;
//        if(pageNo>maxPageNo){
//            pageNo = maxPageNo;
//        }
//        int beginIndex = (pageNo-1)*limit;
//        int endIndex = pageNo*limit;
//        if(endIndex>total){
//            endIndex = total;
//        }
//
//        page = new VoPage(userList.subList(beginIndex, endIndex), total);
//
//        return page;
//    }
}
