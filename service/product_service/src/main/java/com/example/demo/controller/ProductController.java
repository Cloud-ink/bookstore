package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Product;
import com.example.demo.result.Constants;
import com.example.demo.result.R;
import com.example.demo.result.Result;
import com.example.demo.result.VoPage;
import com.example.demo.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @ApiOperation("获取全部商品")
    @PostMapping("/getAllProduct")
    public R getAllProduct(
            @ApiParam("当前页码") @RequestParam("currentPage") int currentPage,
            @ApiParam("每页记录数") @RequestParam("pageSize") int pageSize){
        //生成配置对象
        Page<Product> pageParam = new Page<>(currentPage, pageSize);
        IPage<Product> pageModel = productService.selectPage(pageParam,null);
        List<Product> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return R.ok().data("total",total).data("items",records);
    }

    //点击图片获取商品详细信息
    @PostMapping("/getDetails")
    public R getProductDetails( @RequestParam("productId") int productID){
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id",productID);
        Product product = productService.getProductByProductId(productID,queryWrapper);
        return R.ok().data("items", product);
    }

    //获取商品图片详细信息
    @PostMapping("/getDetailsPicture")
    public R getDetailsPicture( @RequestParam("productId") int productID){
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_id",productID);
        Product product = productService.getProductByProductId(productID,queryWrapper);
        return R.ok().data("items", product);
    }

    //根据搜索获取商品
    @PostMapping("/getProductBySearch")
    public R getProductBySearch(@RequestParam("search") String search,
                                @RequestParam("currentPage") int currentPage,
                                @RequestParam("pageSize") int pageSize){
        Page<Product> page = new Page<>(currentPage,pageSize);
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_name", search);
        IPage<Product> pageModel = productService.selectPage(page, queryWrapper);
        List<Product> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return R.ok().data("items", records).data("total", total);
    }

    @PostMapping("/admin/test")
    public String test(){
        return "aaa";
    }
}