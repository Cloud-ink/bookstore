package com.example.demo.pojo;

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
public class User implements Serializable {
    @ApiModelProperty(value = "用户姓名")
    private String user_name;

    @ApiModelProperty(value = "用户地址")
    private String user_address;

    @ApiModelProperty(value = "用户")
    private Integer user_id;

    @ApiModelProperty(value = "用户邮箱")
    private String user_email;

    @ApiModelProperty(value = "用户号码")
    private int user_phone;

    @JsonIgnore
    @ApiModelProperty(value = "用户密码")
    private transient String user_password;

    @ApiModelProperty(value = "用户性别")
    private int user_gender;

    @ApiModelProperty(value = "用户权限")
    private int user_role;

    @ApiModelProperty(value = "用户生日",example = "2020-10-10") //example是例子，样式怎么写
    private Date user_birthday;

    @ApiModelProperty(value = "用户创建时间")
    private Timestamp user_create_time;

    @ApiModelProperty(value = "用户更新时间")
    private Timestamp user_update_time;
}

