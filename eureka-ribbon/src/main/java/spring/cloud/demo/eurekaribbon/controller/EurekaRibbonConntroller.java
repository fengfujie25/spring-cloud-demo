package spring.cloud.demo.eurekaribbon.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.demo.eurekaribbon.service.EurekaRibbonService;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@RestController
@Slf4j
public class EurekaRibbonConntroller {

    @Autowired
    private EurekaRibbonService eurekaRibbonService;

    @RequestMapping("/sayHello")
    public String syaHello() {
        log.info("eureka-ribbon server......");
        String message = eurekaRibbonService.sayHello();
        log.info("[eureka-ribbon][EurekaRibbonConntroller][syaHello], message={}", message);
        return "ribbon result: " + message;
    }
}
