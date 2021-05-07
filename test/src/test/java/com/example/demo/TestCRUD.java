package com.example.demo;

import com.alibaba.excel.EasyExcel;
import com.example.demo.entity.User;
import com.example.demo.mapper.CartMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCRUD {
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Cart> cartList = cartMapper.selectList(null);
        //Assert.assertEquals(5, cartList.size());
        cartList.forEach(System.out::println);
    }

    //xlsx那版本为office07版
    @Test
    public void simpleWrite(){
        String filename = "C:/Users/haoyun.dai/Desktop/new/test.xlsx";
        EasyExcel.write(filename, User.class)
                .sheet("学生信息")
                .doWrite(data());
    }

    private List<User> data(){
        List<User> list = new ArrayList<>();
        for(int i = 0;i < 10;i++) {
            User user = new User();
            user.setUserName("helen"+i);
            user.setUserPassword("123");
            user.setUserPhone(111);
            list.add(user);
        }
        return list;
    }
}
