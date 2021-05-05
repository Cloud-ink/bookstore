package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.Cart;
import com.example.demo.pojo.vo.CartVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CartMapper extends BaseMapper<Cart> {
    //获取购物车列表
    List<CartVo> getCartList(int userId);

    //批量删除
    int deleteCarts(List<Integer> idList);

    //更新购物车
    int updateCart(int userId, int productId, int cartNum);
}
