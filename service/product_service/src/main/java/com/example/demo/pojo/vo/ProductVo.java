package com.example.demo.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductVo implements Serializable {
    private int productId;
    private String productName;
}
