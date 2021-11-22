package com.mantou.mantoubo.basic.common.encryption;

import java.util.Random;

/**
 * @author lm
 * @title: Encryption
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2114:28
 */
public class Encryption {
    private static final Random RANDOM = new Random();
    /***
     *功能描述 获取随机长度
     * @author MontyLee
     * @date 2021/7/10
     * @param length
     * @return java.lang.String
     */
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=RANDOM.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
