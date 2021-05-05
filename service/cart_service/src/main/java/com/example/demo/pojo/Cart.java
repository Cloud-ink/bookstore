package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("cart")
public class Cart {
    //@TableId(type = IdType.ASSIGN_ID)//自增策略，雪花算法，.AUTO是默认自增
    @TableId(value = "id",type= IdType.AUTO)
    private long id;// 购物车id,雪花算法需要用string类型

    @TableField(value = "user_id")
    private int userId;

    @TableField(value = "product_id")
    private int productId;// 商品id

    @TableField(value = "cart_num")
    private int cartNum;//商品数量

    @TableField(value = "cart_checked")
    private boolean cartChecked;// 是否勾选

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
//    乐观锁
//    @Version//更新是自动检查
//    private int version;

//    private String product_name;// 商品名称
//    private String product_image;// 商品图片
//    private double product_price; //商品价格
//    private int product_stock;// 商品限购数量
}
