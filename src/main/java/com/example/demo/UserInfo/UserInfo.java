package com.example.demo.UserInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UserInfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sid;
    String sname;
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    Date birth;
    String hobby;
    String sex;
    @Column(columnDefinition = "varchar(200) not null")
    String info;
    String email;
    String phone;
    String address;
}
