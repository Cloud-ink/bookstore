package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Test
    public void redisTest() {
//        RedisProperties.Jedis jedis = new RedisProperties.Jedis();
////        jedis.setPool();
//        // jedis.auth("password"); //如果需密码
//        int i = 0;
//        try {
//            long start = System.currentTimeMillis(); // 开始毫秒数
//            while (true) {
//                long end = System.currentTimeMillis();
//                if (end - start >= 1000) {
//                    // 当大于等于1000毫秒（相当于1秒）时，结束操作
//                    break;
//                }
//                i++;
//                jedis.set("test" + i, i + "");
//            }
//        } finally {
//            // 关闭连接
//            jedis.close();
//        }
//        // 打印1秒内对Redis的操作次数
//        System.out.println("reids每秒操作：" + i + "次");
//
    }
}
