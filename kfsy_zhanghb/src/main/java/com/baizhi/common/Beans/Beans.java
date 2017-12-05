package com.baizhi.common.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

@Configuration
public class Beans {


    /**
     * 创建jedis对象
     */
    @Bean("jedis")
    public Jedis getJedis(){
        return new Jedis("192.168.233.128",6379);
    }





}
