package com.example.demo.Util;

import com.alibaba.fastjson.JSONObject;

public class NUllTestUtil {
    public static String testNUll(Object jsonObject){
        if(jsonObject == null){
            return null;
        }else return jsonObject.toString();
    }

}
