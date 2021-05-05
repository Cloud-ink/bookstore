package com.example.demo.exception;

import com.example.demo.result.ResultCodeEnum;
import lombok.Data;
import lombok.ToString;

@Data
public class BookStoreException extends RuntimeException{
    //封装错误码
    private Integer code;
    private boolean success;

    public BookStoreException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    //枚举抛出异常
    public BookStoreException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    //重写tostring，在控制台打印具体信息
    @Override
    public String toString() {
        return "BookStoreException{" +
                "code=" + code +
                ",message="+this.getMessage()+
                '}';
    }
}
