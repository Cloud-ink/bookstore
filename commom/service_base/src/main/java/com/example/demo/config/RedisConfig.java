package com.example.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.time.Duration;

@Configuration
@EnableCaching //开启缓存注解
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory ConnectionFactory){ //生成RedisTemplate时需要一个连接池工厂对象
        //创建redistemplate
        RedisTemplate<String,Serializable> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(ConnectionFactory);//配置连接池
        redisTemplate.setKeySerializer(new StringRedisSerializer());//设置key的序列化方案
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());//设置value的序列化方案
        return redisTemplate;
    }

    @Bean
    //缓存注解的配置
    public CacheManager cacheManager(LettuceConnectionFactory connectionFactory){
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                //过期时间600秒
                .entryTtl(Duration.ofSeconds(600))
                //配置序列化
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))//key值用string的序列化方案
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))//value用json的序列化方案
                .disableCachingNullValues();//值为空不存入缓存

        //构建缓存管理
        RedisCacheManager cacheManager = RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .build();

        return cacheManager;
    }
}
