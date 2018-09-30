package com.linxingwu.consumer.service;

import com.linxingwu.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="hello-service")
public interface ApiHelloService extends HelloService {
}
