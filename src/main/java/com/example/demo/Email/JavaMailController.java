package com.example.demo.Email;

import com.alibaba.fastjson.JSON;
import com.example.demo.Response.Msg;
import com.example.demo.Response.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Random;

@RestController
public class JavaMailController {
    @Autowired
    JavaMailSender javaMailSender;

    //模拟注册的用户发送邮箱验证码功能,会返回给前端
    @CrossOrigin //和下面的response.setHeader("Access-Control-Allow-Origin","*")功能相同
    @RequestMapping(value = "/sendMail",method = RequestMethod.POST)
    public Result sendMail(@RequestBody Map<String,String> paras, HttpServletResponse response) throws MailException {
        //System.out.println(email);
        String email = paras.get("email");
        System.out.println("得到的邮箱是" + email);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("401129874@qq.com");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("验证码");
        int i = new Random().nextInt(899999);
        int i1 = i + 10000;
        simpleMailMessage.setText("您的验证码是:" + i1);
        javaMailSender.send(simpleMailMessage);
        String str = i1 + "";
        System.out.println("邮箱验证码是" + str);
     /*   response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Cache-Control","no-cache");*/
        //response.setHeader("Allow","post,get");
        return new Result(Msg.EmailSendSuccess, str);
    }
}
