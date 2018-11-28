package com.linxingwu.stream.reciver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SinkReceiver {
    @Input
    SubscribableChannel input();
}
