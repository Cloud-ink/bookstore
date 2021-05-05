package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.pojo.Category;
import com.example.demo.pojo.Product;
import com.example.demo.pojo.vo.ProductVo;
import com.example.demo.result.Constants;
import com.example.demo.result.R;
import com.example.demo.result.Result;
import com.example.demo.result.VoPage;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.result.Constants.MESSAGE_OK;
import static com.example.demo.result.Constants.STATUS_OK;

@Api("商品分类有关")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    //获取商品分类列表
    @PostMapping("/getCategoryList")
    public Result getCategory() {
        Result res = new Result();
        List<Category> categorylist = categoryService.listCategoryies();
        System.out.println(categorylist);
        res.setMessage(MESSAGE_OK);
        res.setData(categorylist);
        res.setCode(STATUS_OK);
        return res;
    }

    //获取热门商品
    @PostMapping("/getPromoByCategoryName")
    public R getPromos(@RequestParam String categoryName){
        String category = categoryName;
        List<Product> list = new ArrayList<>();
        System.out.println("asd" + categoryService.getPromosList(categoryName));
        list.addAll(categoryService.getPromosList(categoryName));
        return R.ok().data("PromoProducts",list);
    }

    //根据分类获取商品
    @PostMapping("/getProductByCategory")
    public R getAllProduct(@RequestParam("categoryID") int categoryId,
                           @RequestParam("currentPage") int currentPage,
                           @RequestParam("pageSize") int pageSize){
        Page<Product> page = new Page<>(currentPage, pageSize);
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category_id",categoryId);
        IPage<Product> pageModel = productService.selectPage(page, queryWrapper);
        List<Product> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return R.ok().data("total",total).data("items",records);
    }


    /**
     * redis的简单操作测试
     */
    //测试redistemplate
    //注入redistemplate
    @Autowired
    RedisTemplate redisTemplate;

    //存
    @PostMapping("/testRedis/save")
    public R testSave(@RequestBody ProductVo productVo) {
        redisTemplate.opsForValue().set("pro",productVo);
        redisTemplate.opsForValue().set("a","asdsf");
        return R.ok();
    }

    //取
    @GetMapping("/testRedis/get/{key}")
    public R testGet(@PathVariable String key) {
        //将获取的值转化成原来的类型
        ProductVo productVo = (ProductVo)redisTemplate.opsForValue().get(key);
        return R.ok().data("pro",productVo);
    }

    //删
    @DeleteMapping("/testRedis/remove/{key}")
    public R testRemove(@PathVariable String key) {
        //将获取的值转化成原来的类型
        Boolean delete = redisTemplate.delete(key);
        System.out.println(delete);
        Boolean have = redisTemplate.hasKey(key);//查看是否还有
        return R.ok();
    }
}
