package spring.cloud.demo.spring.gateway.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: fujie.feng
 * @DateT: 2019-10-23
 */
@RestController
public class FallBackController {

    @GetMapping("/fallback")
    public String fallback() {
        return "Error:fallback";
    }

    @GetMapping("/retry")
    public String retry(@RequestParam("name") String name) {
        System.out.println("retry");
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("retry");
        }
        return "retry";
    }
}
