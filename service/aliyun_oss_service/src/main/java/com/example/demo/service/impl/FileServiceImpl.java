package com.example.demo.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.example.demo.service.FileService;
import com.example.demo.util.OssProperties;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private OssProperties ossProperties;

    @Override
    public String upload(InputStream inputStream, String module, String originalFilename) {
        //读取配置信息
        String endpoint = ossProperties.getEndpoint();
        String keyid = ossProperties.getKeyid();
        String keysecret = ossProperties.getKeysecret();
        String bucketname = ossProperties.getBucketname();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyid, keysecret);
        //判断bucket是否存在
        if(!ossClient.doesBucketExist(bucketname)) {
            ossClient.createBucket(bucketname);
            ossClient.setBucketAcl(bucketname, CannedAccessControlList.PublicRead);//设置权限
        }
        //构建objectName：文件路径 acatar/2021/04/02/default.jpg
        String folder = new DateTime().toString("yyyy/MM/dd"); //以时间为文件夹名
        String fileName = UUID.randomUUID().toString(); //文件名
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));//拓展名， .文件格式
        String key = module + "/" + folder + "/" + fileName + fileExtension;
        // 填写Bucket名称和Object完整路径。Object完整路径中不能包含Bucket名称。
        ossClient.putObject(bucketname, key, inputStream);//bucketname，文件路径，输入流

        // 关闭OSSClient。
        ossClient.shutdown();

        return "https://" + bucketname + "." + endpoint + "/" + key;
    }
}
