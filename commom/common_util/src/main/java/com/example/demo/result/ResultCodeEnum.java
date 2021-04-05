package com.example.demo.result;

import io.swagger.annotations.Api;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Api(description = "枚举类")
public enum ResultCodeEnum {
    //外界调用用ResultCodeEnum.SUCCESS.getSuccess
    //自己定义的错误信息
    SUCCESS(true,2000,"成功"),
    FAILED(false,100,"失败"),
    ERROR(false,200,"有异常");


    private Integer code;
    private Boolean success;
    private String message;

    ResultCodeEnum(Boolean success,Integer code,String message){
        this.code = code;
        this.message = message;
        this.success = success;
    }
}
