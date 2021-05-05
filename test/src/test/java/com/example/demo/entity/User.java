package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class User {
    //想要excel表格中有哪些属性，就写哪些
    @ExcelProperty("用户名")//excel标题
    private String userName;

    @ExcelProperty("用户密码")
    private String userPassword;

    @ExcelProperty("用户号码")
    private int userPhone;
}
