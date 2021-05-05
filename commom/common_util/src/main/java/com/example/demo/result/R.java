package com.example.demo.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@ToString
public class R {
    private Integer code;
    private Boolean success;
    private String message;
    private Map<String,Object> data = new HashMap<String,Object>();

    public R(){}

    public static R ok(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.SUCCESS.getSuccess());
        r.setCode(ResultCodeEnum.SUCCESS.getCode());
        r.setMessage(ResultCodeEnum.SUCCESS.getMessage());
        return r;
    }

    public static R error(){
        R r = new R();
        r.setSuccess(ResultCodeEnum.ERROR.getSuccess());
        r.setCode(ResultCodeEnum.ERROR.getCode());
        r.setMessage(ResultCodeEnum.ERROR.getMessage());
        return r;
    }

    public static R setResult(ResultCodeEnum resultCodeEnum){
        R r = new R();
        r.setSuccess(resultCodeEnum.getSuccess());
        r.setCode(resultCodeEnum.getCode());
        r.setMessage(resultCodeEnum.getMessage());
        return r;
    }

    //这和下面的data方法同理，可通过下面data注释的.data方法修改R的值
    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R success(boolean success){
        this.setSuccess(success);
        return this;
    }

    //一个键赋一个值
    public R data(String key,Object value){
        this.data.put(key, value);
        return this;
    }
    //直接赋hashmap
    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
        //用的时候可以return R.ok().data("items",list);
    }
    //一个键赋一个值
    public R message(String message){
        this.setMessage(message);
        return this;
    }
}
