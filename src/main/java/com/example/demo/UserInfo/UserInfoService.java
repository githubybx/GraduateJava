package com.example.demo.UserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.beans.Transient;

@Service
public class UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;
    public UserInfo select(String email){
        return userInfoDao.findByEmail(email);
    }
    @Transactional
    //更新个人信息编辑,sid相同时是update
    public UserInfo  SaveOrUpdateUserInfo(UserInfo userInfo){
        UserInfo save = userInfoDao.save(userInfo);
        return save;
    }
    //更新个人信息编辑,sid相同时是update
//    @Transactional
//    public int  update1(UserInfo userInfo,String email2){
//       return userInfoDao.update(userInfo.sname,userInfo.email,userInfo.address,userInfo.phone,userInfo.info,userInfo.height, email2);
//    }
    public UserInfo findByEmail(String email){
        return userInfoDao.findByEmail(email);
    }
}
