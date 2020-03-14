package com.example.demo.Test;


import com.example.demo.User.User;
import lombok.*;


//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Getter @Setter
    String name;
    @Getter @Setter
    String age;
    @Getter @Setter
    int id;
    @Getter @Setter
    User user;
}
