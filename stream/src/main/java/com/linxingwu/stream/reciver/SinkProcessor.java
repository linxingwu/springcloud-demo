package com.linxingwu.stream.reciver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@EnableBinding({SinkReceiver.class})
public class SinkProcessor {
    private static Logger logger = LoggerFactory.getLogger(SinkProcessor.class);

    @StreamListener(SinkSender.INPUT)
    public void recive(Message<String> value){
        logger.info("Received:\t{}",value.getPayload());
    }
}
