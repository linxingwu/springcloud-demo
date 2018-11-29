package com.linxingwu.stream;

import com.linxingwu.stream.receiver.SinkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@EnableBinding({SinkSender.class})
public class StreamApplicationTests {

    @Autowired
    private SinkSender sender;

    @Test
    public void contextLoads() throws InterruptedException {
        while(true){
            sender.output().send(MessageBuilder.withPayload("Send Message"+System.currentTimeMillis()).build());
            Thread.sleep(1000);
        }
    }

}
