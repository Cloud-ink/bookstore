package com.example.demo.pojo.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class LoginVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
}