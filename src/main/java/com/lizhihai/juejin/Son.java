package com.lizhihai.juejin;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author lizhihai
 * @date 2023/9/4
 * @description
 */
@Service
public class Son extends Father {
    private RedisTemplate redisTemplate;

    public Son(RedisTemplate redisTemplate) {
        super.redisTemplate = redisTemplate;
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void te() {
        System.out.println(this.redisTemplate.toString());
    }
}
