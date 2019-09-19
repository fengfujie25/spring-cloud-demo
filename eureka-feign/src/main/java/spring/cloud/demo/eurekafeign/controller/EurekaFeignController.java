package spring.cloud.demo.eurekafeign.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.demo.eurekafeign.service.EurekaFeignService;

import javax.annotation.Resource;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@RestController
@RequestMapping("/feign")
public class EurekaFeignController {

    @Resource
    private EurekaFeignService eurekaFeignService;

    @RequestMapping("/sayHello")
    public String sayHello() {
        return "feign result: " + eurekaFeignService.syaHello();
    }

}
