package com.wy.channel;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author wangyang
 * @date 2020/8/31 19:21
 * @description:
 */
public interface DefaultProgress {
    String OUTPUT = "wy_output";
    String INPUT = "wy_input";

    @Input(DefaultProgress.INPUT)
    SubscribableChannel input();
    @Output(DefaultProgress.OUTPUT)
    MessageChannel output();
}
