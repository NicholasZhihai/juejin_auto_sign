package com.lizhihai.juejin;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author lizhihai
 * @date 2023/9/4
 * @description
 */
public abstract class Father {
    protected RedisTemplate redisTemplate;

    public abstract void te();

    public void tes() {
        System.out.println(redisTemplate.toString());
    }
}
