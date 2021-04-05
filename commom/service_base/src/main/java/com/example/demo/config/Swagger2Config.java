package com.example.demo.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    //配置swagger
    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")//名字随便起
                .select()   //得到一个路径过滤器
                //包含用and，不包含用not，regex正则表达式，前缀是/api/.*
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))//根据路径路由地址为路径做配置
                .build().apiInfo(webApiInfo());
    }

    //分组策略
    @Bean
    public Docket adminApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("adminApi")
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
                .build().apiInfo(AdminApiInfo());
    }

    //接口信息
    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("网站api文档")
                .description("api接口")
                .version("版本1")
                .contact(new Contact("姓名","网址","邮箱"))
                .build();
    }

    //后台管理员接口
    private ApiInfo AdminApiInfo(){
        return new ApiInfoBuilder()
                .title("网站api文档")
                .description("api接口")
                .version("版本1")
                .contact(new Contact("姓名","网址","邮箱"))
                .build();
    }
}
