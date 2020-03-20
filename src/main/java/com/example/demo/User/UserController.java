package com.example.demo.User;

import com.alibaba.fastjson.JSON;
import com.example.demo.Response.Msg;
import com.example.demo.Response.Result;
import com.example.demo.Util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@CrossOrigin(allowCredentials = "true",origins = {"*"})
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/java/login",method = RequestMethod.POST)
    public Result login(@RequestBody Map<String,String> params, HttpServletResponse response) {
        String email = params.get("email");
        String pass = params.get("pass");
//        HttpSession session = request.getSession();
//        session.setAttribute(email,email + "的信息");
        User byEmailAndPass = userService.findByEmailAndPass(email, pass);
        if (byEmailAndPass == null) {
            System.out.println("登录失败");
            return new Result(Msg.EmailOrPassError);
        } else {
            Cookie cookie = new Cookie("email", email);
            //setPath()设置可以访问cookie的路径
            cookie.setPath("/");
            //设置跨域
//            cookie.setDomain(".*");
            //设置cookie的时长,10分钟
            cookie.setMaxAge(10*60);
            response.addCookie(cookie);
            Cookie cookie1 = new Cookie("email1", email);
            //setPath()设置可以访问cookie的路径
            cookie1.setPath("/");
            //设置跨域
//            cookie.setDomain(".*");
            cookie1.setMaxAge(10*60);
            response.addCookie(cookie1);
            Cookie cookie2 = new Cookie("email2", email);
            //setPath()设置可以访问cookie的路径
            cookie2.setPath("/");
            //设置跨域
//            cookie.setDomain(".*");
            //设置cookie的时长,10分钟
            cookie2.setMaxAge(10*60);
            response.addCookie(cookie2);
            //设置cookie的时长,10分钟

            System.out.println("登录成功");
            return new Result(Msg.LoginSuccess);
        }
    }
    @RequestMapping("/java/regist")
    public Result regist(@RequestBody Map<String,String> params) {
        String email = params.get("email");
        String pass = params.get("pass");
        User byEmailAndPass = userService.findByEmailAndPass(email, pass);
        if (byEmailAndPass != null) {
            System.out.println("重复注册");
            return new Result(Msg.RepeatRegist);
        }
       /* //判断邮箱格式，也可以在前端判断
        if (!EmailUtil.JudgeEmail(email)) {
            return new Result(Msg.EmailFormatError);
        }*/
       /* //判断验证码是否输入正确
        if (!testVerifyCode.equals(myVerifyCode)) {
            //验证码输入错误，直接的返回对应信息
            return new Result(Msg.InputVerifyCodeError);
        }*/
        //将用户的邮箱和密码存储在数据库中
        User user = new User(email, pass);
        User save = userService.save(user);
        if (save == null) {
            return new Result(Msg.RegistFailed);
        } else {
            return new Result(Msg.RegistSucess);
        }
    }
}
