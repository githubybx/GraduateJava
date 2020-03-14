package com.example.demo.UserInfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.User.User;

import java.util.ArrayList;
import java.util.List;

public class Jsontest {
    public static void main(String[] args) {
        //普通json格式对象与javabean对象之间的互转
        User user = new User("401129874@qq.com","123456");
        String string = JSON.toJSONString(user);
        System.out.println("bean对象转换为json格式字符串" + string);
        User user1 = JSON.parseObject(string, User.class);
        System.out.println("json格式转换为bean对象" + user1.toString());
        String str = "{\"email\":\"401129874@qq.com\",\"pass\":\"123456\",\"id\":0}";
        User user2 = JSON.parseObject(str, User.class);
        System.out.println("json格式转换为bean对象" + user2.toString());
        String str2 = "{\"id\":2,\"email\":\"张三\",\"pass\":34}";
        User user3 = JSON.parseObject(str2, User.class);
        System.out.println(user3.toString());
        //json集合与javabean对象之间的转换
        ArrayList<String> strings = new ArrayList<>();
        strings.add("jack");
        strings.add("rose");
        strings.add("kitty");
        String string1 = JSON.toJSONString(strings);
        System.out.println(string1);
        String str1 = "[\"jack\",\"rose\",\"kitty\"]";
        JSONArray objects = JSON.parseArray(str1);
        String string11 = objects.toJSONString();
        System.out.println(objects);
        List lists = JSON.parseArray(string1, String.class);
        System.out.println(lists.toString());
    }
}
