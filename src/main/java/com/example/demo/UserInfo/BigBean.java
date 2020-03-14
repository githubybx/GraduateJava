package com.example.demo.UserInfo;

import com.example.demo.User.User;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BigBean {
    List list;
    Map<String,String> map;
    String[] array;
    Date date;
    int num;
    User user;

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigBean(List list, Map<String, String> map, String[] array, Date date, int num, User user) {
        this.list = list;
        this.map = map;
        this.array = array;
        this.date = date;
        this.num = num;
        this.user = user;
    }

    public BigBean(List list, Map<String, String> map, String[] array, Date date, int num) {
        this.list = list;
        this.map = map;
        this.array = array;
        this.date = date;
        this.num = num;
    }

    public BigBean() {
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
