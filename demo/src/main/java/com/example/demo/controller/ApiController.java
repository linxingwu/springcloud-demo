package com.example.demo.controller;

import com.linxingwu.entity.User;
import com.linxingwu.service.HelloService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController implements HelloService {
    @Override
    public String hello(String name) {
        return "Hello "+name;
    }

    @Override
    public User hello(String name, Integer age) {
        return new User(name,age);
    }

    @Override
    public String hello(User user) {
        return "Hello "+user.getName()+" you are "+user.getAge()+" years old";
    }
}
