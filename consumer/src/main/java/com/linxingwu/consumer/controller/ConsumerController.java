package com.linxingwu.consumer.controller;

import com.linxingwu.consumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    HelloService service;

    @RequestMapping("/ribbon-consumer")
    public String helloConsumer() {
        return service.helloService()+",from ribbon";
    }
}
