package com.linxingwu.stream.receiver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SinkReceiver {
    @Input(SinkSender.INPUT)
    SubscribableChannel input();
}
