package com.linxingwu.stream.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding({Processor.class})
public class SinkProcessor {
    private static Logger logger = LoggerFactory.getLogger(SinkProcessor.class);

    @StreamListener(Processor.INPUT)
    @SendTo({Processor.OUTPUT})
    public Object receive(Message<String> value){
        logger.info("Received:\t{}",value.getPayload());
        return "Do not answer\t"+value.getPayload()+"->处理过后的数据";
    }
}
