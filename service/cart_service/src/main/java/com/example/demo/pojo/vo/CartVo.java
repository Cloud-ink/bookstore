package com.example.demo.pojo.vo;

import lombok.Data;

@Data
public class CartVo {
    private String id;
    private int productId;
    private int userId;
    private String productName;
    private int cartChecked;
    private int cartNum;
    private int productPrice;
    private String productImage;
    private int productStock;
}
