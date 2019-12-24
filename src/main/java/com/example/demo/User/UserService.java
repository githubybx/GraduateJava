package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public User findByEmailAndPass(String email,String pass){
        return userDao.findByEmailAndPass(email,pass);
    }
    public User save(User user){
       return userDao.save(user);
    }

}
