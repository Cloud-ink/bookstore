package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product implements Serializable {
    private Long product_id;
    private String product_name;
    private String product_image;
    private Long product_price;
    private Long product_salePrices;
    private String product_salePoint;
    private Long category_id;
    private String product_typeName;
    private Boolean product_flag;
    private Date product_updateTime;
    private Date product_createTime;
    private Long product_createUser;
    private Double product_selling_price;
    private String product_subtitle;
    private int product_stock;
}
