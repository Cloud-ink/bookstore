package com.example.demo.controller;

import com.example.demo.pojo.Product;
import com.example.demo.result.Result;
import com.example.demo.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CollectController {
    @Autowired
    CollectService collectService;

    @PostMapping("/getCollect")
    public Result getCollect(@RequestParam("user_id") int user_id){
        Result res = new Result();
        List<Product> list = new ArrayList<>();
        list.addAll(collectService.getCollectByUserId(user_id));
        res.setCode(20000);
        res.setMessage("获取收藏成功");
        res.setData(list);
        return res;
    }
    //添加收藏
    @PostMapping("/addCollect")
    public Result addCollect(@RequestParam("user_id") int user_id,
                             @RequestParam("product_id") int product_id){
        Result res = new Result();
        collectService.addCollectByUserId(user_id,product_id);
        res.setCode(20000);
        res.setMessage("添加收藏成功");
        return res;
    }
    //删除收藏
    @PostMapping("/deleteCollect")
    public Result deleteCollect(@RequestParam("user_id") int user_id,
                                @RequestParam("product_id") int product_id){
        Result res = new Result();
        collectService.deleteCollectByUserId(user_id,product_id);
        res.setCode(20000);
        res.setMessage("删除收藏成功");
        return res;
    }

}
