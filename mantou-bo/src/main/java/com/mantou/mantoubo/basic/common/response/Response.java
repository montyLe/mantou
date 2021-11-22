package com.mantou.mantoubo.basic.common.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lm
 * @title: Response
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2114:29
 */
@Data
public class Response {
    private boolean success;

    private int code;

    private String message;

    private Map<String,Object> data = new HashMap<>();

    public Response() {
    }

    /***
     *功能描述 成功响应
     * @author MontyLee
     * @date 2021/7/2
     * @param
     * @return com.pl.jbs.base.util.response.ResponseData
     */
    public static Response OK(){
        Response responseData = new Response();
        responseData.setCode(ResCode.SUCCESS.getCode());
        responseData.setMessage(ResCode.SUCCESS.getMessage());
        responseData.setSuccess(ResCode.SUCCESS.getSuccess());
        return responseData;
    }

    /***
     *功能描述  失败响应
     * @author MontyLee
     * @date 2021/7/2
     * @param
     * @return com.pl.jbs.base.util.response.ResponseData
     */
    public static Response FAIL(){
        Response responseData = new Response();
        responseData.setCode(ResCode.FAIL.getCode());
        responseData.setMessage(ResCode.FAIL.getMessage());
        responseData.setSuccess(ResCode.FAIL.getSuccess());
        return responseData;
    }

    /***
     *功能描述  系统错误响应
     * @author MontyLee
     * @date 2021/7/2
     * @param
     * @return com.pl.jbs.base.util.response.ResponseData
     */
    public static Response ERROR(){
        Response responseData = new Response();
        responseData.setCode(ResCode.ERROR.getCode());
        responseData.setMessage(ResCode.ERROR.getMessage());
        responseData.setSuccess(ResCode.ERROR.getSuccess());
        return responseData;
    }


    public Response data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

    public Response data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public Response success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Response code(Integer code){
        this.setCode(code);
        return this;
    }

    public Response message(String message){
        this.setMessage(message);
        return this;
    }
}
