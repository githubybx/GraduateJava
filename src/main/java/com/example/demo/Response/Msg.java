package com.example.demo.Response;

public class Msg {
    int code;
    String message;

    public Msg(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public static final Msg EmailOrPassError = new Msg(100001,"邮箱或者手机号错误");
    public static final Msg LoginSuccess = new Msg(1000002,"登陆成功");
    public static final Msg RepeatRegist = new Msg(1000003,"重复注册");
    public static final Msg RegistSucess = new Msg(1000004,"注册成功");
    public static final Msg RegistFailed = new Msg(1000005,"注册失败");
    public static final Msg EmailFormatError = new Msg(1000006,"邮箱格式错误");
    public static final Msg EmailSendSuccess = new Msg(1000007,"邮箱发送成功");
    public static final Msg InputVerifyCodeError = new Msg(1000008,"邮箱验证码输入错误");

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

    public static Msg getEmailOrPassError() {
        return EmailOrPassError;
    }

    public static Msg getLoginSuccess() {
        return LoginSuccess;
    }
}
