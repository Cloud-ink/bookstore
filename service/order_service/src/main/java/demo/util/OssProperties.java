package demo.util;

import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")//将aliyun.oss为前缀的配置信息都读取出来
@Api(description = "可以批量配置一些自己定义的配置")
public class OssProperties {
    //自动查找同名文件
    private String endpoint;
    private String keyid;
    private String keysecret;
    private String bucketname;
}
