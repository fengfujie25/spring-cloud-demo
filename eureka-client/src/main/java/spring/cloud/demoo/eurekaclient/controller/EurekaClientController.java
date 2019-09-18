package spring.cloud.demoo.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@RestController
public class EurekaClientController {

    @Value("${server.port}")
    private String port;

//    @Value("${info}")
//    private String info;

    @RequestMapping("/info")
    public String syaHello(HttpServletRequest request) {
        String message = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getServletPath();
        return message;
    }

//    @RequestMapping("/config")
//    public String getInfoConfig() {
//        return info;
//    }
}
