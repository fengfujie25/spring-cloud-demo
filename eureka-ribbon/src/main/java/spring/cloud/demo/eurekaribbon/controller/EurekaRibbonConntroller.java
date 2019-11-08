package spring.cloud.demo.eurekaribbon.controller;

import brave.Tracer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.cloud.demo.eurekaribbon.service.EurekaRibbonService;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@RestController
@Slf4j
public class EurekaRibbonConntroller {

//    Logger log = LoggerFactory.getLogger(EurekaRibbonConntroller.class);

    @Autowired
    private EurekaRibbonService eurekaRibbonService;

    @Autowired
    private Tracer tracer;

    @RequestMapping("/sayHello")
    public String syaHello(HttpServletRequest request) {

        log.info("eureka-ribbon server......");
        String message = eurekaRibbonService.sayHello();
        log.info(">>>traceId={}, spanId={}", request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
        log.info("[eureka-ribbon][EurekaRibbonConntroller][syaHello], message={}, traceId={}", message, tracer.currentSpan().context().traceIdString());
        return "ribbon result: " + message;
    }
}
