package cdu.gu.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;

@Configuration
public class RedisConfig {
    /**
     * RedisTemplate是Spring Data Redis提供的一个用于与Redis交互的高级模板类
     * @param redisConnectionFactory 用于指定Redis连接工厂，该工厂来创建redis连接
     * @return
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate<String,Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        //创建实例
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //key值采用StringRedisSerializer序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //设置Redis的建的序列化器
        redisTemplate.setKeySerializer(stringRedisSerializer);
        //设置Redis的哈希键的序列化器
        redisTemplate.setHashKeySerializer(stringRedisSerializer);

        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer =
                new GenericJackson2JsonRedisSerializer();
        //设置Redis的值的序列化器
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        //设置Redis的哈希值的序列化器
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        return redisTemplate;
    }

    /**
     * 这是一个Lua脚本，实现一些复杂的Redis操作，列如分布式限流
     * @return
     */
    @Bean(name = "rateLimiterScript")
    public RedisScript<Long> rateLimiterScript(){
        //创建实例，表示lua脚本返回的是long类型
        DefaultRedisScript<Long> script = new DefaultRedisScript<>();
        //通过该方法将lua脚本的源码加载自一个资源文件
        script.setScriptSource(
                new ResourceScriptSource(new ClassPathResource("lua/RateLimiterScript.lua"))
        );
        //通过该方法设置lua脚本的返回类型为long
        script.setResultType(Long.class);
        return script;
    }
}
