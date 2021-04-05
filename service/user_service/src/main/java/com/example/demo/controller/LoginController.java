package com.example.demo.controller;

import com.example.demo.result.Result;
import com.example.demo.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.result.Constants.STATUS_FAIL;

@Api(description = "用户登录用")
@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    LoginService loginService;

    @ApiOperation("注册")
    @PostMapping("/register")
    public Result register(@RequestParam("userName") String username,
                           @RequestParam("pass") String pass){
        Result res = new Result();
        if(loginService.register(username,pass)) {
            res.setMessage("注册成功");
            res.setCode(20000);
        }else{
            res.setMessage("注册失败");
            res.setCode(STATUS_FAIL);
        }
        return res;
    }

    @ApiOperation(value = "是否已注册",notes = "详细信息")
    @PostMapping("/findUserName")
    public Result findUserName(@ApiParam("传入参数的注解") @RequestParam("userName") String username){
        Result res = new Result();
//        if(loginService.findUserName(username)) {
//            res.setMessage("可以注册");
//            res.setCode(20000);
//        }else{
//            res.setMessage("已注册");
//            res.setCode(STATUS_FAIL);
//        }
        return res;
    }
    //登录
    @PostMapping("/login")
    public Result login(@RequestParam("userName") String username,
                        @RequestParam("pass") String pass){
        Result res = new Result();
        boolean user = loginService.findByUserName(username);
//        if(user.getUser_password().equals(pass)){
//            res.setCode(20000);
//            res.setMessage("成功");
//            res.setData(user);
//        }
//        else{
//            res.setMessage("登录失败");
//            res.setCode(STATUS_FAIL);
//        }
        return res;
    }
}
