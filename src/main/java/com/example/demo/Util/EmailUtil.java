package com.example.demo.Util;

import com.example.demo.Response.Msg;
import com.example.demo.Response.Result;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtil {
    public static Boolean JudgeEmail(String email) {
        Pattern compile = Pattern.compile("^\\d+@\\w+\\.com$");
        Matcher matcher = compile.matcher(email);
        return matcher.matches();
    }
}
