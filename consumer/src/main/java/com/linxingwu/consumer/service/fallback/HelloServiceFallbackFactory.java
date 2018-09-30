package com.linxingwu.consumer.service.fallback;

import com.linxingwu.consumer.service.ApiHelloService;
import com.linxingwu.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

//@Component
public class HelloServiceFallbackFactory implements FallbackFactory<ApiHelloService> {
    @Override
    public ApiHelloService create(Throwable t) {
        return new ApiHelloService() {
            @Override
            public String hello(String name) {
                return "出错，因为"+t.getCause();
            }

            @Override
            public User hello(String name, Integer age) {
                return null;
            }

            @Override
            public String hello(User user) {
                return "出错，因为"+t.getMessage();
            }
        };
    }
}
