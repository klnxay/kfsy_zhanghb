package com.baizhi.common.util;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class Ali {

    public static String a(int length) {

        String chars = "1234567890";
        StringBuilder s = new StringBuilder();
        for(int i =0;i<length;i++){
            s.append(chars.charAt(new Random().nextInt(10)));
        }
        String a = s.toString();
        Jedis jedis = new Jedis("192.168.233.128",6379);
        jedis.set("code",a);
        jedis.pexpire("code",60000l);

        return a;
    }
}
