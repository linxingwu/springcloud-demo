package com.linxingwu.consumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import rx.Observable;
import rx.Subscriber;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsumerApplicationTests {

    @Test
    public void contextLoads() {
    }

    public static void main(String[] args){
        Observable<String> observable = Observable.create((Observable.OnSubscribe<String>) subscriber -> {
            subscriber.onNext("Hello World");
            subscriber.onCompleted();
        });
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("job done");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("job error");
            }

            @Override
            public void onNext(String s) {
                System.out.println("收到消息\t"+s);
            }
        };

        observable.subscribe(subscriber);
    }
}
