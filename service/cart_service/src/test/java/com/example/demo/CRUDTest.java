package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.CartMapper;
import com.example.demo.pojo.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CRUDTest {
    @Autowired
    private CartMapper cartMapper;

//    @Test
//    public void testSelect() {
//        System.out.println(("----- selectAll method test ------"));
//        List<Cart> cartList = cartMapper.selectList(null);
//        //Assert.assertEquals(5, cartList.size());
//        cartList.forEach(System.out::println);
//    }

    @Test
    public void testInsert(){
        Cart cart = new Cart();
        cart.setUserId(1234);
        cart.setProductId(3);
//        cart.setCartChecked(1);
        cart.setCartNum(10);
        cart.setCreateTime(new Date());
        cart.setUpdateTime(new Date());

        int result = cartMapper.insert(cart);
        System.out.println("行数"+result);
    }

    @Test
    public void testUpdataById(){
        Cart cart = new Cart();
        cart.setId(13);
        cart.setUserId(555);

        int result = cartMapper.updateById(cart);
        System.out.println("行数"+result);
    }

    @Test   //批量查询id
    public void testSelectBatchIds(){
        List<Cart> carts = cartMapper.selectBatchIds(Arrays.asList(9,10));
        carts.forEach(System.out::println);
    }

    @Test   //集合查询
    public void testSelectByMap(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("user_id","555");
        map.put("product_id","0");
        List<Cart> carts = cartMapper.selectByMap(map);
        carts.forEach(System.out::println);
    }

    @Test
    public void testSelectPage(){

        //条件构造器,构造条件
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_id","product_id");//只查询选中的
//        //1
//        Page<Cart> page = new Page<>(1,3);
//        //Page<Cart> pageParam = cartMapper.selectPage(page,null);//无条件
//        Page<Cart> pageParam = cartMapper.selectPage(page,queryWrapper);//有条件
//        List<Cart> records = pageParam.getRecords();
        //2.使用map 只返回选中的列
        Page<Map<String,Object>> page = new Page<>(1,3);
        Page<Map<String,Object>> pageParam = cartMapper.selectMapsPage(page,queryWrapper);//有条件
        List<Map<String,Object>> records = pageParam.getRecords();


        records.forEach(System.out::println);
        System.out.println(pageParam.getPages());//总页数
        System.out.println(pageParam.getTotal());//总条数
        System.out.println(pageParam.getCurrent());//当前页码
        System.out.println(pageParam.getSize());//每页数量
        System.out.println(pageParam.hasNext());//是否有上一页
        System.out.println(pageParam.hasPrevious());//是否有下一页
    }
}
