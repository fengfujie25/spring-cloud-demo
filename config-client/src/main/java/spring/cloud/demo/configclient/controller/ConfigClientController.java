package spring.cloud.demo.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@RestController
public class ConfigClientController {

    @Value("${info}")
    private String info;

    @RequestMapping("/config/info")
    public String info() {
        return info;
    }

}
