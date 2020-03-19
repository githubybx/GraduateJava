package com.example.demo.Response;

public class Msg {
    int code;
    String message;

    public Msg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static final Msg EmailOrPassError = new Msg(1000001, "邮箱或者手机号错误");
    public static final Msg LoginSuccess = new Msg(1000002, "登陆成功");
    public static final Msg RepeatRegist = new Msg(1000003, "重复注册");
    public static final Msg RegistSucess = new Msg(1000004, "注册成功");
    public static final Msg RegistFailed = new Msg(1000005, "注册失败");
    public static final Msg EmailFormatError = new Msg(1000006, "邮箱格式错误");
    public static final Msg EmailSendSuccess = new Msg(1000007, "邮箱发送成功");
    public static final Msg InputVerifyCodeError = new Msg(1000008, "邮箱验证码输入错误");
    public static final Msg UserInfoIsNUll = new Msg(1000009, "用户信息不存在");
    public static final Msg UserInfoSelectSuccess = new Msg(1000010, "用户信息查找成功");
    public static final Msg UpdateUserInfoFailed = new Msg(1000011, "更新个人信息失败");
    public static final Msg UpdateUserInfoSuccess = new Msg(1000012, "更新个人信息成功");
    public static final Msg FaceResultIsNull = new Msg(1000013, "人脸信息为空");
    public static final Msg FaceResultIsSuccess = new Msg(1000014, "人脸信息获取成功");
    public static final Msg SelectAllProductSuccess = new Msg(1000015, "获取商品信息成功");
    public static final Msg SelectAllProductFailed = new Msg(1000016, "获取商品信息失败");
    public static final Msg SelectProductByIdFailed = new Msg(1000017, "获取指定商品信息失败");
    public static final Msg SelectProductByIdSuccess = new Msg(1000018, "获取指定商品信息成功");
    public static final Msg SelectUserInfoByEmailSuccess = new Msg(1000019, "根据邮箱获取用户简介成功");
    public static final Msg SelectUserInfoByEmailFailed = new Msg(1000020, "根据邮箱获取用户简介失败");
    public static final Msg UpdateOrAddProductSuccess = new Msg(1000021, "更改或者添加商品成功");
    public static final Msg UpdateOrAddProductFaild = new Msg(1000022, "更改或者添加商品失败");

    //上传文件部分
    public static final Msg LoadFileSuccess = new Msg(1000023, "上传文件成功");
    public static final Msg LoadFileFaild = new Msg(1000024, "上传文件失败");

    //人脸情绪识别部分
    public static final Msg EmotionDetectSuccess = new Msg(1000025, "情绪识别成功");
    public static final Msg EmotionDetectFailed = new Msg(1000026, "情绪识别失败");
    public static final Msg GetAllEmotionMsgSuccess = new Msg(1000027, "获取情绪识别结果成功");
    public static final Msg GetAllEmotionMsgFailed = new Msg(1000028, "获取情绪识别结果失败");




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
