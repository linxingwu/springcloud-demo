package com.linxingwu.stream.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * 通过名为inputMessage的binder监听消息，处理之后发送到outputMessage的binder
 */
@EnableBinding({SinkSender.class,SinkReceiver.class})
public class SinkProcessor {
    private static Logger logger = LoggerFactory.getLogger(SinkProcessor.class);

    @StreamListener(SinkSender.INPUT)
    @SendTo({SinkSender.OUTPUT})
    public Object receive(Message<String> value){
        logger.info("Received:\t{}",value.getPayload());
//        int i = 1/0;
        return "Do not answer\t"+value.getPayload()+"->处理过后的数据";
    }
    @ServiceActivator(inputChannel = SinkSender.INPUT+".serviceGroup.errors")
    public void error(Message message){
        logger.error("Handing Error:\t{}",message);
    }
}
