package com.example.demo.mapper;

import com.example.demo.pojo.Order;
import com.example.demo.pojo.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> getAllOrder(int user_id);
    //获取收藏列表
    List<Product> getCollectByUserId(int user_id);
    //添加收藏
    int addCollectByUserId(int user_id,int product_id);
    //删除收藏
    int deleteCollectByUserId(int user_id,int product_id);
    //添加订单
    int addOrder(int user_id,int product_id,int product_num,int product_price);
}