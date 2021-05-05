package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(value = "轮播图对象",description = "轮播图") //对字段加描述
@TableName(value = "carousels")
public class Carousel implements Serializable {

    @ApiModelProperty(value = "轮播图Id")
    @TableId(value = "carousel_id",type= IdType.AUTO)
    private int carouselId;

    @ApiModelProperty(value = "轮播图url地址")
    @TableField(value = "carousel_img")
    private String carouselImg;

    @ApiModelProperty(value = "轮播图名称")
    @TableField(value = "carousel_name")
    private String carouselName;
}
