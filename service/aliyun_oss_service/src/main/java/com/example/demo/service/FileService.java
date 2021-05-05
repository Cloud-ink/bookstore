package com.example.demo.service;

import java.io.InputStream;

public interface FileService {
    /**
     * aliyun文件上传
     * @param inputStream 输入流
     * @param module 文件夹名称
     * @param originalFilename 原始文件名
     * @return 文件在oss服务器上的url地址
     */
    String upload(InputStream inputStream,String module,String originalFilename);
}
