package com.linxingwu.stream.receiver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

public interface SinkReceiver {
    @Input(Sink.INPUT)
    SubscribableChannel input();
}
