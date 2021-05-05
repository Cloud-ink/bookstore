package com.example.demo.handler;

import com.example.demo.exception.BookStoreException;
import com.example.demo.result.R;
import com.example.demo.result.ResultCodeEnum;
import com.example.demo.util.ExceptionUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(description = "统一异常处理器")
@Slf4j  //可以使用日志
@ControllerAdvice  //做一个切面，处理异常信息
public class GlobalExceptionHandler {

    //统一异常处理
    @ExceptionHandler(Exception.class)  //异常处理器
    @ResponseBody //异常也要返回统一结果，统一结果是个json字符串，所以使用@ResponseBody
    public R error(Exception e){  //这里的exception是自动注入的
        //e.printStackTrace();  //版本1.打印异常跟踪站  2.只在控制台上打印出来
        //log.error(e.getMessage());//2.在日志文件中打印，但是打印出的内容格式不是品尝看的
        log.error(ExceptionUtils.getMessage(e));//3.输出内容既在控制台也在日志文件中,此处的方法是自己写的异常工具类ExceptionUtils，格式也是平常形式
        return R.error();
    }

    //异常抛出后进入这个类，会最先匹配最接近，相同的异常
    //如果接受了NullPointerException异常，但是没找到，就会去找这个异常的父类，就是上面的Exception
    //特殊异常处理
    @ExceptionHandler(NullPointerException .class)  //异常处理器
    @ResponseBody //异常也要返回统一结果，统一结果是个json字符串，所以使用@ResponseBody
    public R error(NullPointerException  e){  //这里的exception是自动注入的
        //e.printStackTrace();  //打印异常跟踪站
        log.error(ExceptionUtils.getMessage(e));
        return R.setResult(ResultCodeEnum.ERROR);//通过枚举来注入错误信息
    }

    //捕获自定义异常
    @ExceptionHandler(BookStoreException.class)  //异常处理器
    @ResponseBody //异常也要返回统一结果，统一结果是个json字符串，所以使用@ResponseBody
    public R error(BookStoreException e){  //这里的exception是自动注入的
        //e.printStackTrace();  //打印异常跟踪站
        log.error(ExceptionUtils.getMessage(e));
        return R.error().success(e.isSuccess()).message(e.getMessage()).code(e.getCode());//通过枚举来注入错误信息
    }
}
