package com.example.demo.controller;

import com.example.demo.exception.BookStoreException;
import com.example.demo.result.R;
import com.example.demo.result.ResultCodeEnum;
import com.example.demo.service.FileService;
import com.example.demo.util.ExceptionUtils;
import com.example.demo.util.OssProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

import static com.example.demo.result.ResultCodeEnum.ERROR;

@Api(description = "阿里云文件管理")
@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/admin")
public class AliyunOssController {
    @Autowired
    FileService fileService;
    @Autowired
    OssProperties ossProperties;

    //@ApiOperation("文件上传")
    @PostMapping("/upload")
    public R upload(
            @ApiParam(value = "文件",required = true)
            @RequestParam("file") MultipartFile file,
            @ApiParam(value = "模块",required = true)
            @RequestParam("module") String module) {
        try {
            InputStream inputStream = file.getInputStream();
            String originalFilename = file.getOriginalFilename();
            String uploadUrl = fileService.upload(inputStream, module, originalFilename);
            return R.ok().message("文件上传成功").data("url", uploadUrl);
        }catch (Exception e) {
            //打印真正的错误信息
            log.error(ExceptionUtils.getMessage(e));
            throw new BookStoreException(ResultCodeEnum.ERROR);
        }
    }

    @GetMapping("/test")
    public String test(){
        System.out.println(ossProperties.getKeyid());
        return "test";}
}
