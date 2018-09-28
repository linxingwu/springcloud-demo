package com.linxingwu.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@Deprecated
@FeignClient("hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
