package com.example.demo.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends JpaRepository<User, Integer> {
    public User findByEmailAndPass(@Param("email") String email, @Param("pass") String pass);
}
