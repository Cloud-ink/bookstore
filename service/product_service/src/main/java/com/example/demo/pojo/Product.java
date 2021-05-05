package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value = "products")
public class Product implements Serializable {

    @TableId(value = "product_id",type= IdType.AUTO)
    private Long productId;

    @TableField(value = "product_name")
    private String productName;

    @TableField(value = "product_image")
    private String productImage;

    @TableField(value = "product_price")
    private Long productPrice;

    @TableField(value = "product_selling_price")
    private Long productSellingPrice;

    @TableField(value = "category_id")
    private Long categoryId;

    @TableField(value = "product_typeName")
    private String productTypeName;

    @TableField(value = "product_updateTime")
    private Date productUpdateTime;

    @TableField(value = "product_createTime")
    private Date productCreateTime;

    @TableField(value = "product_subtitle")
    private String productSubtitle;

    @TableField(value = "product_stock")
    private int productStock;
}
