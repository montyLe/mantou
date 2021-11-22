package com.mantou.mantoubo.basic.common.constant;

/**
 * @author lm
 * @title: UtilConstants
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2114:27
 */
public interface UtilConstants {
    /***
     *功能描述 公共常量类
     * @author MontyLee
     * @date 2021/7/13
     */
    public static class Public {
        // 密码盐长度
        public static final Integer SALT_LENGTH = 32;

        // 加密类型
        public static final String ENCRYPTION_TYPE = "MD5";
        // 加密次数
        public static final Integer ENCRYPTION_TIMES = 1024;
    }

    /*** 用户状态
     *功能描述
     * @author MontyLee
     * @date 2021/7/13
     */
    public  static class UserStatus{
        // 正常
        public static final Integer NORMAL = 0;
        // 冻结
        public static final Integer FROZEN = 1;
        // 失效
        public static final Integer INVALID = 2;
    }
}
