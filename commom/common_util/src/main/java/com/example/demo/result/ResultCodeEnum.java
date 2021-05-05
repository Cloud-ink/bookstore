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
    SUCCESS(true,20000,"成功"),
    FAILED(false,100,"失败"),
    ERROR(false,200,"有异常"),

    LOGIN_ERROR(false,23004,"获取用户信息失败"),

    ADD_COLLECT_ERROR(false,25001,"添加购物车失败");

    private Integer code;
    private Boolean success;
    private String message;

    ResultCodeEnum(Boolean success,Integer code,String message){
        this.code = code;
        this.message = message;
        this.success = success;
    }
}
