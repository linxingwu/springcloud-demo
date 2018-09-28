package com.linxingwu.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;
    @Autowired
    private Registration registration;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String hello(){
        List<ServiceInstance> list = client.getInstances(registration.getServiceId());
        for (ServiceInstance instance : list) {
            logger.info("host: "+instance.getHost()+"\tservice_id:"+instance.getServiceId());
        }
        return "hello world";
    }
}
