package com.example.demo.Other;

import com.example.demo.User.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OtherController {
    @RequestMapping(value = "/get/myname",method = RequestMethod.GET)
    public User getSth(@RequestParam("name")String name,User user,User user2,String name1){
        System.out.println(name);
        System.out.println(user.toString());
        System.out.println(user2.toString());
        System.out.println(name1);
        return new User("张三","23232",3);
    }
    @RequestMapping(value = "/post/sth",method = RequestMethod.GET)
    public User getSth1(@RequestBody User user){
        System.out.println(user.toString());
        return null;
    }
    @RequestMapping(value = "/get/age",method = RequestMethod.GET)
    public User getSth(@RequestParam("name")String name){
        System.out.println(name);
        return new User("张三","23232",3);
    }
    @RequestMapping(value = "/get/header",method = RequestMethod.POST)
    public User getSth1(@RequestHeader("name")String name){
        System.out.println(name);
        return new User("张三","23232",3);
    }
}
