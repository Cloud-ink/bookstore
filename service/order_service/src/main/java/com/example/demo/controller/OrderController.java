package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.pojo.Order;
import com.example.demo.result.Result;
import com.example.demo.service.OrderService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    //获取订单列表
    @PostMapping("/getOrder")
    public Result getOrder(@RequestParam("user_id") int user_id){
        Result res = new Result();
        List<Order> list = new ArrayList<>();
        list.addAll(orderService.getAllOrder(user_id));
        List<Object> list1 =new ArrayList<>();
        list1.addAll(list);
        res.setCode(20000);
        res.setMessage("查询订单成功");
        res.setData(list1);
        return res;
    }
    //添加订单
    @PostMapping("/addOrder")
    public Result addOrder(@RequestBody String data){
        Result res = new Result();
        //String a = data.products;
        //int user_id = (int)data.get("user_id");
        // List<Product> list =(List<Product>)data.get("products");
//        for(int i = 0 ; i < list.toArray().length;i++){
//            System.out.println(list.toArray().length);
//            int id = list.
//            //orderService.addOrder(list.);
//        }
//        JsonParser jsonParser = new JsonParser();
//        JsonObject json = jsonParser.parse("json串").getAsJsonObject();
//        JsonObject jsonelement = jjson.get("key").getAsJsonObject();
//        JsonArray arr = jsonelement.get("key").getAsJsonArray();
//        for (int j = 0; j < arr.size(); j++)
//        {
//            JsonObject e = arr.get(j).getAsJsonObject();
//            System.out.println(e.get("key"));
//        }
        JSONObject jsonObject = JSON.parseObject(data);
        // 然后根据名称获取 名称下的数据
        int showapiResBody = jsonObject.getInteger("user_id");
        String products = jsonObject.getString("products");
        try {
            org.json.JSONArray array = new JSONArray(products);//将json字符串转成json数组
            for (int i = 0; i < array.length(); i++) {//循环json数组
                org.json.JSONObject ob = (org.json.JSONObject) array.get(i);//得到json对象
                int product_id = ob.getInt("product_id");//name这里是列名称，获取json对象中列名为name的值
                int product_num = ob.getInt("cart_num");
                int product_price = ob.getInt("product_price");
                orderService.addOrder(showapiResBody,product_id,product_num,product_price);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //orderService.addOrder(list);
        res.setCode(20000);
        res.setMessage("添加订单成功");
        return res;
    }
}