package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("collect")
public class Collect implements Serializable {

    @TableId(value = "id",type= IdType.AUTO)
    private int id;

    @TableField(value = "collect_id")
    private int colletId;

    @TableField(value = "user_id")
    private int userId;

    @TableField(value = "product_id")
    private int productId;

}
