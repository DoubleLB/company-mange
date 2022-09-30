package org.example.company.common;

/**
 * 封装API接口标准返回结果
 * @param <T>
 */

public class Result <T>{

    public static final int CODE_OK = 200;
    public static final int CODE_ERR_BUSINESS = 500;
    public static final int CODE_ERR_UNLOGIN = 520;
    public static final int CODE_ERR_SYS = 530;


    public static <T> Result<T> OK(){
        return new Result<>(true, CODE_OK, null, null);
    }
    public static <T> Result<T> OK(String message){
        return new Result<>(true, CODE_OK, message, null);
    }
    public static <T> Result<T> OK(String message,T data){
        return new Result<>(true, CODE_OK, message, data);
    }

    public static <T> Result<T> OK(T data){
        return new Result<>(true, CODE_OK, null, data);
    }

    public static <T> Result<T> err(int errCode,String message){
        return new Result<>(false, errCode, message, null);
    }
    public static <T> Result<T> err(int errCode,String message,T data){
        return new Result<>(false, errCode, message, data);
    }




    private boolean success;//操作是否成功
    private int code;//操作状态码 这是自定义的的： 200 成功， 500业务失败，520 未登录 ,530 系统错误
    private String message;//概要信息
    private T data;//服务端向前端传送的额外数据

    private Result(boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
