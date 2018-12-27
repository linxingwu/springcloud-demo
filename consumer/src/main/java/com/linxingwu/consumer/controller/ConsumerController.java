package com.linxingwu.consumer.controller;

import com.linxingwu.consumer.service.ApiHelloService;
import com.linxingwu.entity.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    RestTemplate restTemplate;

    @Resource
    ApiHelloService service;

    @RequestMapping("/feign-consumer")
    public String feignConsumer() {
        StringBuffer sb = new StringBuffer();
        sb.append(service.hello("张三")).append("\n");
        sb.append(service.hello("lisi",20)).append("\n");
        sb.append(service.hello(new User("王五",25))).append("\n");


        return  sb.toString()+",from ribbon";
    }
    @RequestMapping("/ribbon-consumer")
    public String ribbonConsumer() {
        StringBuffer sb = new StringBuffer();
        sb.append(restTemplate.getForObject("http://hello-service/api/hello4?name={1}",String.class,"张三")).append("\n");

        HttpHeaders headers = new HttpHeaders();
        headers.clear();
        headers.set("name","Liam");
        headers.set("age","30");
        HttpEntity entity = new HttpEntity(headers);
        sb.append(restTemplate.exchange("http://hello-service/api/hello5", HttpMethod.GET,entity,User.class).getBody()).append("\n");
        sb.append(restTemplate.postForObject("http://hello-service/api/hello6",new User("张三",21),String.class)).append("\n");


        return  sb.toString()+",from ribbon";
    }
}
