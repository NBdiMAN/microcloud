package com.wy.listener;

import com.wy.channel.DefaultProgress;
import com.wy.vo.Product;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author wangyang
 * @date 2020/8/31 18:28
 * @description:
 */
@Component
@EnableBinding(DefaultProgress.class)
public class MessageListener {
    @StreamListener(DefaultProgress.INPUT)
    public void input(Message<Product> message){
        System.out.println("消息接收" + message.getPayload());
    }
}
