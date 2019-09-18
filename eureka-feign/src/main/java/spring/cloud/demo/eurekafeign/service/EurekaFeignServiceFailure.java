package spring.cloud.demo.eurekafeign.service;

import org.springframework.stereotype.Service;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@Service
public class EurekaFeignServiceFailure implements EurekaFeignService {
    @Override
    public String syaHello() {
        return "网络繁忙，请稍后在试";
    }
}
