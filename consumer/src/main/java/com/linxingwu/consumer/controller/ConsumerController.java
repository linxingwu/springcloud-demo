package com.linxingwu.consumer.controller;

import com.linxingwu.consumer.service.ApiHelloService;
import com.linxingwu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    ApiHelloService service;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer() {
        StringBuffer sb = new StringBuffer();
        sb.append(service.hello("张三")).append("\n");
        sb.append(service.hello("lisi",20)).append("\n");
        sb.append(service.hello(new User("王五",25))).append("\n");


        return  sb.toString()+",from ribbon";
    }
}
