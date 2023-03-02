package com.github.azhch.j.example.spring.annotation;

import com.github.azhch.j.example.spring.annotation.bo.User;
import com.github.azhch.j.example.spring.annotation.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExample {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.github.azhch.j.example.spring.annotation");
        context.refresh();

        User user = context.getBean(UserService.class).getUser(1);

        User user2 = context.getBean(UserService.class).getUser(2);
        System.out.println(user);

        System.out.println(user == user2);
    }

}
