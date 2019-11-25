package spring.cloud.demo.eurekaribbon.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @auther: fujie.feng
 * @DateT: 2019-11-24
 */
@EnableBinding(Sink.class)
public class RecieceService {

    @StreamListener(Sink.INPUT)
    public void recieve(Object payload) {
        System.out.println(payload);
    }
}
