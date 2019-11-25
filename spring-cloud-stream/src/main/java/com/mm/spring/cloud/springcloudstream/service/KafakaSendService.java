package com.mm.spring.cloud.springcloudstream.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @auther: fujie.feng
 * @DateT: 2019-11-24
 */
@EnableBinding(Source.class)
public class KafakaSendService {

    @Autowired
    private Source source;

    public void sendMsg(String msg) {
        source.output().send(MessageBuilder.withPayload(msg).build());
    }
}
