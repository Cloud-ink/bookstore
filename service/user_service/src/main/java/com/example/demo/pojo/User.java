package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

@ApiModel(value = "用户对象",description = "用户") //对字段加描述
@TableName(value = "user")
public class User implements Serializable {

    @ApiModelProperty(value = "用户Id")
    @TableId(value = "user_id",type= IdType.AUTO)
    private String userId;

    @ApiModelProperty(value = "用户姓名")
    @TableField(value = "user_name")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    @TableField(value = "user_password")
//    private transient String userPassword;
    private String userPassword;

    @ApiModelProperty(value = "用户邮箱")
    @TableField(value = "user_email")
    private String userEmail;

    @ApiModelProperty(value = "用户号码")
    @TableField(value = "user_phone")
    private int userPhone;

    @ApiModelProperty(value = "用户性别")
    @TableField(value = "user_gender")
    private int userGender;

    @ApiModelProperty(value = "用户地址")
    @TableField(value = "user_address")
    private String userAddress;

    @ApiModelProperty(value = "用户权限")
    @TableField(value = "user_role")
    private int userRole;

    @ApiModelProperty(value = "用户生日",example = "2020-10-10") //example是例子，样式怎么写
    @TableField(value = "user_birthday")
    private Date userBirthday;

    @ApiModelProperty(value = "用户创建时间")
    @TableField(value = "user_createtime")
    private Timestamp userCreatetime;

    @ApiModelProperty(value = "用户更新时间")
    @TableField(value = "user_updatetime")
    private Timestamp userUpdatetime;

}

