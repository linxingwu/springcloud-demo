package com.linxingwu.consumer.service;

import com.linxingwu.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="provider-demo")
public interface ApiHelloService extends HelloService {
}
