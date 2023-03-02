package com.github.azhch.j.example.spring.annotation;

import com.github.azhch.j.example.spring.annotation.bo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(value = "userConfig",proxyBeanMethods = false)
public class UserConfig {

    @Bean
    public User newUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("admin");
        user.setPassword("******");
        user.setName("测试");
        return user;
    }
}
