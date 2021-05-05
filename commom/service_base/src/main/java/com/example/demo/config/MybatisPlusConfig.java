package com.example.demo.config;


import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

import com.github.yulichang.interceptor.MPJInterceptor;
import io.swagger.annotations.Api;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Api("乐观锁插件")
@Configuration
@MapperScan({"com.example.demo.mapper"})
@EnableTransactionManagement    //事务处理
public class MybatisPlusConfig {
    /**
     * 乐观锁插件
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * 联表查询插件
     */
    @Bean
    public MPJInterceptor MPJInterceptor(){
        return new MPJInterceptor();
    }
}
