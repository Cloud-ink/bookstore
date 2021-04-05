package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order implements Serializable {
    private int order_id;
    private int order_no;
    private int user_id;
    private int product_id;
    private String product_name;
    private String product_image;
    private int product_num;
    private int product_price;
    private Data payment_time;
}