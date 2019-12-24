package com.example.demo.Response;

public class Result<T> {
    int code;
    String message;
    T data;

    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Msg msg){
        this.code = msg.code;
        this.message = msg.message;
    }
    public Result(Msg msg, T data){
        this.code = msg.code;
        this.message = msg.message;
        this.data = data;
    }
    public static Result Success = new Result(1,"success");
    public static Result Failed = new Result(0,"success");

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static Result getSuccess() {
        return Success;
    }

    public static void setSuccess(Result success) {
        Success = success;
    }

    public static Result getFailed() {
        return Failed;
    }

    public static void setFailed(Result failed) {
        Failed = failed;
    }
}
