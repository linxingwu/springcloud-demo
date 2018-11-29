package com.linxingwu.stream.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.util.Date;

@EnableBinding({Processor.class})
public class SinkProcessor {
    private static Logger logger = LoggerFactory.getLogger(SinkProcessor.class);

    @Bean
    @InboundChannelAdapter(value = Processor.OUTPUT,poller = @Poller(fixedDelay = "2000"))
    public MessageSource<Date> timerMessageSource(){
        return ()-> new GenericMessage<>(new Date());
    }

    @StreamListener(value = Processor.INPUT)
    public void receive(Message<String> msg){
        logger.info("收到消息:\t{}",msg.getPayload());
    }
}
