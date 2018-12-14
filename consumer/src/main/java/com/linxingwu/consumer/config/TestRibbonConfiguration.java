package com.linxingwu.consumer.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

//本配置打开会导致找不到client
@Configuration
@RibbonClient(name="hello-service",configuration = MyRibbonConfig.class)
public class TestRibbonConfiguration {
}
