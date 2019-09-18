package spring.cloud.demo.eurekafeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@FeignClient(value = "eureka-client", fallback = EurekaFeignServiceFailure.class)
public interface EurekaFeignService {

    @RequestMapping(value = "/info")
    String syaHello();
}
