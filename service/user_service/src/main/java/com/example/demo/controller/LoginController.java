package com.example.demo.controller;

import com.example.demo.exception.BookStoreException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.vo.LoginVo;
import com.example.demo.pojo.vo.RegisterVo;
import com.example.demo.result.JwtUtil;
import com.example.demo.result.R;
import com.example.demo.result.Result;
import com.example.demo.result.ResultCodeEnum;
import com.example.demo.service.LoginService;
import com.example.demo.util.JwtInfo;
import com.example.demo.util.JwtToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.example.demo.result.Constants.STATUS_FAIL;

@Api(description = "用户登录用")
@RestController
@RequestMapping("/user")
@Log4j
public class LoginController {
    @Autowired
    LoginService loginService;

    @ApiOperation("注册")
    @PostMapping("/register")
    public R register(@RequestBody RegisterVo registerVo){
        try {
            String username = registerVo.getUsername();
            String password = registerVo.getPassword();

        }catch (Exception e) {

        }
        return R.ok();
    }

//    @ApiOperation(value = "是否已注册",notes = "详细信息")
//    @PostMapping("/findUserName")
//    public Result findUserName(@ApiParam("传入参数的注解") @RequestParam("userName") String username){
//        Result res = new Result();
////        if(loginService.findUserName(username)) {
////            res.setMessage("可以注册");
////            res.setCode(20000);
////        }else{
////            res.setMessage("已注册");
////            res.setCode(STATUS_FAIL);
////        }
//        return res;
//    }

    //登录验证
    @ApiOperation("登录")
    @PostMapping("/login")
    public R login(@RequestBody LoginVo loginVo){
        String token = loginService.login(loginVo);
        return R.ok().data("token",token).message("登录成功");
    }

    @ApiOperation("返回用户信息")
    @GetMapping("/info")
    public R getLoginInfo(HttpServletRequest request){
        System.out.println("结果"+request);
        try {
            JwtInfo jwtInfo = JwtToken.getMemberIdByJwtToken(request);
            return R.ok().data("userInfo",jwtInfo);
        }catch (Exception e) {
            log.error("解析失败：" + e.getMessage());
            throw new BookStoreException(ResultCodeEnum.LOGIN_ERROR);
        }
    }
}
