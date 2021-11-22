package com.mantou.mantoubo.config.handler;

import com.baomidou.kaptcha.exception.KaptchaException;
import com.baomidou.kaptcha.exception.KaptchaIncorrectException;
import com.baomidou.kaptcha.exception.KaptchaNotFoundException;
import com.baomidou.kaptcha.exception.KaptchaTimeoutException;
import com.mantou.mantoubo.basic.common.response.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author lm
 * @title: GlobalExceptionHandler  @RestControllerAdvice:RestController增强，捕获全局异常
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2115:17
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = KaptchaException.class)
    public Response kaptchaExceptionHandler(KaptchaException kaptchaException) {
        if (kaptchaException instanceof KaptchaIncorrectException) {
            return Response.FAIL().message("验证码不正确") ;
        } else if (kaptchaException instanceof KaptchaNotFoundException) {
            return Response.FAIL().message("验证码未找到") ;
        } else if (kaptchaException instanceof KaptchaTimeoutException) {
            return Response.FAIL().message("验证码过期") ;
        } else {
            return Response.FAIL().message("验证码渲染失败") ;
        }
    }
}
