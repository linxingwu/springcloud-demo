package com.linxingwu.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
public class ProviderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ProviderApplication.class, args);
        String url = context.getEnvironment().getProperty("eureka.client.service-url.defaultZone");
        System.out.println(url);
    }
}
