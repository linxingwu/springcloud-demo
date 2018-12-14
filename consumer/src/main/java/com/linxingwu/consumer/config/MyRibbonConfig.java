package com.linxingwu.consumer.config;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//在启动类中已经排除了这个类
@Configuration
public class MyRibbonConfig  {
    @Bean
    public ILoadBalancer ribbonLoadBalancer(){
        System.out.println("=============");
        return new BaseLoadBalancer();
    }
}
