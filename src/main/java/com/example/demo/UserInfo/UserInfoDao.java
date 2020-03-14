package com.example.demo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserInfoDao extends JpaRepository<UserInfo,Integer>{
    public UserInfo findByEmail(String emial);
    @Modifying
    @Query(value = "update user_info set sname = ?1,email = ?2,address = ?3,phone = ?4,info = ?5,height = ?6 where email = ?7",nativeQuery = true)
    public int update(String sname,String email1,String address,String phone,String into,float height,String email);
}
