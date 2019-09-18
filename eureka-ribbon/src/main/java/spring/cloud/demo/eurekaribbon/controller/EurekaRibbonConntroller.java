package spring.cloud.demo.eurekaribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.demo.eurekaribbon.service.EurekaRibbonService;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@RestController
public class EurekaRibbonConntroller {

    @Autowired
    private EurekaRibbonService eurekaRibbonService;

    @RequestMapping("/syaHello")
    public String syaHello() {
        String message = eurekaRibbonService.sayHello();
        return "ribbon result: " + message;
    }
}
