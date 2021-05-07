package com.example.demo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("cart")
public class Cart {
    private int cartId;
    private int userId;
    private int productId;
    private int cartNum;
    private int cartChecked;
    private int cartPrice;
}
