package com.baizhi.common.util;

import java.util.Random;

/**
 * 用来生成项目中随机盐
 */
public class SaltUtils {



    /**
     * 用来生成随机盐
     * @param n   生成的位数
     * @return  返回生成随机盐
     */

    public static String getSalts(int n){

        char[] codes = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
        //生成随机值
        Random random = new Random();
        //StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(codes[random.nextInt(codes.length)]);
        }
        return sb.toString();
    }


    public static String getSalt(int n){

        char[] codes = "0123456789".toCharArray();
        //生成随机值
        Random random = new Random();
        //StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(codes[random.nextInt(codes.length)]);
        }
        return sb.toString();
    }

}
