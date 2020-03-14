package com.example.demo.UserInfo;

import com.alibaba.fastjson.JSON;
import com.example.demo.Response.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Response.Result;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;


@RestController
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;
    //Post方式修改个人信息
    @CrossOrigin
    @RequestMapping(value = "/get/SaveOrUpdateUserInfo",method = RequestMethod.POST)
    public Result getUserInfo(@RequestBody Map<String,UserInfo> params, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin","*");
        UserInfo form = params.get("form");
        UserInfo userInfo = userInfoService.SaveOrUpdateUserInfo(form);
        //UserInfo userInfo = JSON.parseObject(form, UserInfo.class);
        if(userInfo != null){
            return new Result(Msg.UpdateUserInfoSuccess,userInfo);
        }
        System.out.println("form");
        System.out.println(form.toString());
        return new Result(Msg.UpdateUserInfoFailed);
    }

    @RequestMapping(value = "/post/findByEmail",method = RequestMethod.GET)
    public Result updateUserInfo(@RequestParam("email")String email,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        UserInfo byEmail = userInfoService.findByEmail(email);
        if(byEmail != null){
            return new Result(Msg.SelectUserInfoByEmailSuccess,byEmail);
        }else {
            return new Result(Msg.SelectUserInfoByEmailFailed);
        }
    }


}
////        if(select == null){
////            return new Result(Msg.UserInfoIsNUll);
////        }else {
////            return new Result(Msg.UserInfoSelectSuccess,select);
////        }
//       /* @RequestMapping(value = "/update/userinfo",method = RequestMethod.GET)
//    public Result updateUserInfo(UserInfo userInfo){
//        System.out.println(userInfo.getAddress() + " " + userInfo.getEmail() + " " + userInfo.getHeight());
//        UserInfo update = userInfoService.update(userInfo);
//        if(update == null){
//            return new Result(Msg.UpdateUserInfoFailed);
//        }else{
//            return new Result(Msg.UpdateUserInfoSuccess,update);
//        }
//    }*/
////    @RequestMapping(value = "/update/userinfo",method = RequestMethod.GET)
////    public Result updateUserInfo(UserInfo userInfo,@RequestParam("email2")String email2){
//////        System.out.println(userInfo.getAddress() + " " + userInfo.getEmail() + " " + userInfo.getHeight());
//////        int a = userInfoService.update1(userInfo,email2);
////        if(a <= 0){
////            return new Result(Msg.UpdateUserInfoFailed);
////        }else{
////            return new Result(Msg.UpdateUserInfoSuccess);
////        }
////    }
//
