package com.linxingwu.consumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//在启动类中已经排除了这个类
@Configuration
public class MyRibbonConfig  {

    @Bean
    public ILoadBalancer ribbonLoadBalancer(IClientConfig config,
                                            ServerList<Server> serverList, ServerListFilter<Server> serverListFilter,
                                            IRule rule, IPing ping, ServerListUpdater serverListUpdater) {
        return new MyLoadBalancer(config, rule, ping, serverList,
                serverListFilter, serverListUpdater);
    }

}

//必须使用有参构造方法传入serverlist，否则调用找不到server报错
class MyLoadBalancer extends DynamicServerListLoadBalancer{
    MyLoadBalancer(IClientConfig config, IRule rule, IPing ping, ServerList<Server> serverList, ServerListFilter<Server> serverListFilter, ServerListUpdater serverListUpdater) {
        super(config,rule,ping,serverList,serverListFilter,serverListUpdater);
    }
    MyLoadBalancer(){}

}
