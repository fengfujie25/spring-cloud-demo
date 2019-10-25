package spring.cloud.demo.spring.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
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

}
