package com.example.demo.controller;

import com.linxingwu.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@Deprecated
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "hello " + name;
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public User Hello(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name,age);

    }
    @RequestMapping(value = "/hello2",method = RequestMethod.POST)
    public String Hello(@RequestBody User user){
        logger.info("receive request:"+user.toString());
        return "Hello "+user.getName()+" you are "+user.getAge()+" years old";

    }
}
