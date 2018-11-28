package com.linxingwu.stream.reciver;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SinkSender {
    String INPUT = "inputMessage";

    @Output(SinkSender.INPUT)
    MessageChannel output();


}
