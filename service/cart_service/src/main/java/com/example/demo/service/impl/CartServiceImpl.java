package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.example.demo.mapper.CartMapper;
import com.example.demo.pojo.Cart;
import com.example.demo.pojo.vo.CartVo;
import com.example.demo.service.CartService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartMapper cartMapper;

    //获取购物车列表
    @Override
    public List<CartVo> getCartList(int userId){
        List<CartVo> carts = cartMapper.getCartList(userId);
        return carts;
    }

    //添加
    @Override
    public int addCart(int userId, int productId) {
        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProductId(productId);
        cart.setCreateTime(new Date());
        cart.setUpdateTime(new Date());
        int result = cartMapper.insert(cart);
        return result;
    }

    //更新
    @Override
    public int updateCart(int userId, int productId, int cartNum) {
        int result = cartMapper.updateCart(userId, productId, cartNum);
        return result;
    }

    //删除
    @Override
    public int deleteCart(int userId, int productId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("product_id", productId);
        return cartMapper.delete(queryWrapper);
    }

    //是否已存在
    @Override
    public boolean isCart(int userId, int productId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("user_id", userId);
        queryWrapper.eq("product_id", productId);
        int carts = cartMapper.selectCount(queryWrapper);
        boolean isCart = false;
        if(carts > 0) {
            isCart = true;
        }
        return isCart;
    }

    @ApiOperation("批量删除")
    @Override
    public boolean deleteCarts(List<Integer> idList) {
        boolean isDelete = false;
        if(CollectionUtils.isEmpty(idList)){
            return false;
        }
        Integer result = cartMapper.deleteCarts(idList);
        if(null != result && result >= 1) {
            isDelete = true;
        }
        return isDelete;
    }

}
