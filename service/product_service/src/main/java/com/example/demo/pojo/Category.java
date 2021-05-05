package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@ApiModel(value = "商品分类对象",description = "商品分类")
@TableName(value = "category")
public class Category implements Serializable {

    @ApiModelProperty(value = "商品分类Id")
    @TableId(value = "category_id",type= IdType.AUTO)
    private Integer categoryId;

    @ApiModelProperty(value = "父分类Id")
    @TableField(value = "parent_id")
    private Integer parentId;

    @ApiModelProperty(value = "商品分类名称")
    @TableField(value = "category_name")
    private String categoryName;

    @ApiModelProperty(value = "商品分类状态")
    @TableField(value = "category_status")
    private String categoryStatus;

    @ApiModelProperty(value = "商品分类排序")
    @TableField(value = "sort_order")
    private String categoryOrder;

}
