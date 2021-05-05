package com.example.demo.controller;

import com.example.demo.pojo.Cart;
import com.example.demo.pojo.vo.CartVo;
import com.example.demo.result.R;
import com.example.demo.service.CartService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/cart")
@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @ApiOperation("获取购物车列表")
    @PostMapping("/getCart")
    public R getCart(@RequestParam("userId") int userId){
        List<CartVo> list = cartService.getCartList(userId);
        if(list.size() > 0) {
            return R.ok().message("获取购物车列表成功").data("carts", list);
        } else {
            return R.ok().message("还未添加购物车");
        }
    }

    @ApiOperation("添加购物车")
    @PostMapping("/addCart")
    public R addCart(@RequestParam("userId") int userId,
                     @RequestParam("productId") int productId){
        boolean isChecked = cartService.isCart(userId, productId);
        if(isChecked){
            return R.ok().message("已存在");
        } else {
            cartService.addCart(userId, productId);
            return R.ok().message("添加成功");
        }
    }

    @ApiOperation("删除购物车")
    @PostMapping("/deleteCart")
    public R deleteCart(@RequestParam("userId") int userId,
                        @RequestParam("productId") int productId){
        int cart = cartService.deleteCart(userId,productId);
        if(cart > 0) {
            return R.ok().message("删除成功");
        } else {
            return R.ok().message("没有物品");
        }
    }

    @ApiOperation("更新购物车")
    @PostMapping("/updateCart")
    public R updateCart(
            @ApiParam(value = "用户", required = true)
            @RequestParam("userId") int userId,
            @ApiParam(value = "商品Id", required = true)
            @RequestParam("productId") int productId,
            @ApiParam(value = "用户", required = true)
            @RequestParam("currentValue") Integer cartNum){
        int result = cartService.updateCart(userId, productId, cartNum);
        if(result > 0) {
            return R.ok().code(20001).message("更新购物车成功");
        } else {
            return R.ok().message("未更新成功");
        }
    }

    @ApiOperation("批量删除购物车")
    @PostMapping("/deleteCarts")
    public R deleteCarts(
            @ApiParam(value = "商品id列表", required = true)
            @RequestBody List<Integer> idList){
        boolean result = cartService.deleteCarts(idList);
        if(result) {
            return R.ok().message("删除成功");
        } else {
            return R.ok().message("购物车不存在该商品");
        }
    }


}
