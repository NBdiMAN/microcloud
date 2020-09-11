package com.wy.service.impl;

import com.wy.channel.DefaultProgress;
import com.wy.service.IMessageProvider;
import com.wy.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


/**
 * @author wangyang
 * @date 2020/8/31 17:06
 * @description:
 */
@EnableBinding(DefaultProgress.class)
@Service
public class MessageProviderImpl implements IMessageProvider {
    @Autowired
    @Qualifier("wy_output")
    private MessageChannel output;

    @Override
    public void send(Product product) {
        output.send(MessageBuilder.withPayload(product).build());
    }
}
