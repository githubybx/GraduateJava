package com.example.demo.User;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Data
@AllArgsConstructor
public class User {
    String email;
    String pass;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    public User(String email,String pass){
        this.email = email;
        this.pass = pass;
    }

    public User() {
    }

}
