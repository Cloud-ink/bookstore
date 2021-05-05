package com.example.demo.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import io.swagger.annotations.Api;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
@Api(description = "自动填充插入时间，更新时填充更新时间")
@Component
public class MyMetabObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime",new Date(),metaObject);//根据名字设置字段的值
        this.setFieldValByName("updateTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime",new Date(),metaObject);

    }
}
