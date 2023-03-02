package com.github.azhch.j.example.spring.annotation.service;

import com.github.azhch.j.example.spring.annotation.bo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(scopeName = "prototype")
public class UserServiceImpl implements UserService{
    @Value("#{newUser}")
    private User user;
    @Override
    public User getUser(Integer id) {
        return user;
    }
}
