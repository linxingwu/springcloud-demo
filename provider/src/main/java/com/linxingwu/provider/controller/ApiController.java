package com.linxingwu.provider.controller;

import com.linxingwu.entity.User;
import com.linxingwu.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController implements HelloService {
    @Override
    public String hello(@RequestParam String name) {
        return "Hello "+name;
    }

    @Override
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        return new User(name,age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "Hello "+user.getName()+" you are "+user.getAge()+" years old";
    }
}
