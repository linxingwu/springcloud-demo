package com.linxingwu.provider.controller;

import com.linxingwu.entity.User;
import com.linxingwu.service.HelloService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ApiController implements HelloService {
    @Override
    public String hello(@RequestParam String name) {
        try {
            int i = new Random().nextInt(3000);
            System.out.println("@RequestParam String name Sleep "+i+"ms");
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello "+name;
    }

    @Override
    public User hello(@RequestHeader String name, @RequestHeader Integer age) {
        try {
            int i = new Random().nextInt(3000);
            System.out.println("@RequestHeader String name, @RequestHeader Integer age Sleep "+i+"ms");
            Thread.sleep(i);        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User(name,age);
    }

    @Override
    public String hello(@RequestBody User user) {
        try {
            int i = new Random().nextInt(3000);
            System.out.println("@RequestBody User user Sleep "+i+"ms");
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello "+user.getName()+" you are "+user.getAge()+" years old";
    }
}
