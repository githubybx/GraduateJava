package com.example.demo.User;

import com.example.demo.Response.Msg;
import com.example.demo.Response.Result;
import com.example.demo.Util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    public Result login(@RequestParam("email")String email, @RequestParam("pass")String pass){
        User byEmailAndPass = userService.findByEmailAndPass(email, pass);
        if(byEmailAndPass == null){
            System.out.println("登录失败");
            return new Result(Msg.EmailOrPassError);
        }else {
            System.out.println("登录成功");
            return new Result(Msg.LoginSuccess);
        }
    }

    /**
     *
     * @param email
     * @param pass
     * @param myVerifyCode 用户输入的验证码信息
     * @param testVerifyCode　发送给用户邮箱的验证码
     * @return
     */
    @RequestMapping("/regist")
    public Result regist(@RequestParam("email")String email, @RequestParam("pass")String pass,@RequestParam("mvc")String myVerifyCode,@RequestParam("tvc")String testVerifyCode){
        User byEmailAndPass = userService.findByEmailAndPass(email, pass);
        if(byEmailAndPass != null){
            System.out.println("重复注册");
            return new Result(Msg.RepeatRegist);
        }
        //判断邮箱格式，也可以在前端判断
        if(!EmailUtil.JudgeEmail(email)){
            return new Result(Msg.EmailFormatError);
        }
        //判断验证码是否输入正确
        if(!testVerifyCode.equals(myVerifyCode)){
            //验证码输入错误，直接的返回对应信息
           return new Result(Msg.InputVerifyCodeError);
        }
        //将用户的邮箱和密码存储在数据库中
        User user = new User(email, pass);
        User save = userService.save(user);
        if(save == null){
            return new Result(Msg.RegistFailed);
        }else {
            return new Result(Msg.RegistSucess);
        }
    }
}
