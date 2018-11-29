package com.linxingwu.stream.receiver;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SinkSender {
    String INPUT = "inputMessage";

    @Output
    MessageChannel output();


}
