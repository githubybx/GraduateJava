package com.example.demo.UserInfo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.User.User;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class JsonTest2 {
    public static void main(String[] args) {
        //复杂对象
        BigBean bigBean = new BigBean();
        String[] array = {"jack","rose","kitty"};
        bigBean.setList(Arrays.asList(array));
        bigBean.setArray(array);
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("name","张三");
        stringStringHashMap.put("age","23");
        bigBean.setMap(stringStringHashMap);
        bigBean.setDate(new Date());
        User user = new User("email","pass",32);
        bigBean.setUser(user);
        bigBean.setNum(23);
        String string = JSON.toJSONString(bigBean);
        System.out.println("复杂对象转换为json字符串" + string);
        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println(jsonObject);
        //数组对象
        String[] array1 = {"jack","rose","kitty"};
        String string1 = JSON.toJSONString(array);
        List<String> strings = JSON.parseArray(string1, String.class);
        System.out.println("json格式数组格式转换为数组" + string1);
        //日期对象转换为json格式
        Date date = new Date();
        String string2 = JSON.toJSONString(date);
        System.out.println("日期格式转换为JSON字符串" + string2);
        Date parse = JSON.parseObject(string2, Date.class);
        System.out.println(parse);
    }
}
