package com.example.demo.controller;

import com.example.demo.exception.BookStoreException;
import com.example.demo.pojo.Product;
import com.example.demo.result.R;
import com.example.demo.result.ResultCodeEnum;
import com.example.demo.service.CollectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/product")
public class CollectController {

    @Autowired
    CollectService collectService;

    @ApiOperation("添加购物车")
    @PostMapping("/addCollect")
    public R addCollect(@PathParam("userId") int userId,
                        @PathParam("productId") int productId){
        R result = new R();
        if(collectService.isCollected(userId,productId)) {
            result = R.ok().message("已添加过收藏");
        }else {
            int addCollect = collectService.addCollect(userId, productId);
            if (addCollect != 1) {
                throw new BookStoreException(ResultCodeEnum.ADD_COLLECT_ERROR);
            }
            result = R.ok().message("添加成功");
        }
        return result;
    }

    @ApiOperation("获取购物车列表")
    @PostMapping("/getCollect")
    public R getCollect(@PathParam("userId") int userId){
        List<Product> products = collectService.getCollect(userId);
        R result = new R();
        if(products.size() != 0) {
            result = R.ok().message("获取收藏列表成功").data("collects", products);
        }else {
            result = R.ok().message("还未添加收藏");
        }
        return result;
    }

    @ApiOperation("删除购物车列表")
    @PostMapping("/deleteCollect")
    public R deleteCollection(@PathParam("userId") int userId,
                              @PathParam("productId") int productId){
        int collect = collectService.deleteCollect(userId, productId);
        R result = new R();
        if(collect != 0) {
            result = R.ok().message("删除成功");
        }
        return result;
    }


}
