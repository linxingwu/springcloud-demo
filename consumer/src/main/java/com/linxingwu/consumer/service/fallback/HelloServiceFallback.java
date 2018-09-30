package com.linxingwu.consumer.service.fallback;

import com.linxingwu.consumer.service.ApiHelloService;
import com.linxingwu.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/api/fallback")
public class HelloServiceFallback implements ApiHelloService {
    @Override
    public String hello(String name) {
        return "出错";
    }

    @Override
    public User hello(String name, Integer age) {
        return null;
    }

    @Override
    public String hello(User user) {
        return "出错";
    }
}
