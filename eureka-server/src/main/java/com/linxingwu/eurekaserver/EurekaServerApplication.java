package com.linxingwu.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import java.util.concurrent.*;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) throws InterruptedException {
//        SpringApplication.run(EurekaServerApplication.class, args);
        LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        SynchronousQueue<Runnable> sq = new SynchronousQueue<>();
        ThreadFactory threadFactory = r -> {
            Thread thread = new Thread(r);
            thread.setName("");
            return thread;
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,100L, TimeUnit.MILLISECONDS,queue,threadFactory);

        for (int i = 0;;i++){
            System.out.println("running"+i);
            Thread.sleep(1000);
        }

    }
}
