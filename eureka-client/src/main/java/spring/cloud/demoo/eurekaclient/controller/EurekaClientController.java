package spring.cloud.demoo.eurekaclient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@RestController
@Slf4j
public class EurekaClientController {

    @Value("${server.port}")
    private String port;

//    @Value("${info}")
//    private String info;

    @RequestMapping("/info")
    public String syaHello(HttpServletRequest request) {
        log.info("eureka-client come in requst = {}", request);
        String message = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
        log.info("eureka-client end message = {}", message);
        return message;
    }

//    @RequestMapping("/config")
//    public String getInfoConfig() {
//        return info;
//    }
}
