package com.linxingwu.consumer.service;

import com.linxingwu.consumer.config.FeignConfiguration;
import com.linxingwu.consumer.service.fallback.HelloServiceFallback;
import com.linxingwu.consumer.service.fallback.HelloServiceFallbackFactory;
import com.linxingwu.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value="hello-service",fallback = HelloServiceFallback.class,configuration = FeignConfiguration.class)
public interface ApiHelloService extends HelloService {
}
