package com.example.demo.User;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    String email;
    String pass;
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    public User() {
    }

    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
