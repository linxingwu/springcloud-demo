package com.linxingwu.consumer.service;

import com.linxingwu.consumer.config.FeignConfiguration;
import com.linxingwu.consumer.service.fallback.HelloServiceFallback;
import com.linxingwu.service.HelloService;
import org.springframework.cloud.openfeign.FeignClient;

//本注解自动创建同名Ribbon客户端，可以为客户端指定具体的Ribbon配置
@FeignClient(value="hello-service",fallback = HelloServiceFallback.class,configuration = FeignConfiguration.class)
public interface ApiHelloService extends HelloService {
}
