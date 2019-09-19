package spring.cloud.demo.eurekaribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@Service
public class EurekaRibbonService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"),
            @HystrixProperty(name = "execution.isolation.strategy",value = "THREAD")},
            fallbackMethod = "syaHelloFailure")
    public String sayHello() {
        String message;
        try {
            System.out.println("调用 服务 eureka-client/info");
            message = restTemplate.getForObject("http://eureka-client/info", String.class);
            System.out.println("服务 eureka-client/info 返回信息：" + message);
            System.out.println("调用 服务 eureka-client/info success");
        } catch (RestClientException e) {
            message = e.getMessage();
        }
        return message;
    }

    public String syaHelloFailure() {
        System.out.println("error come in ");
        String message = "网络繁忙， 请稍后再试";
        return message;
    }
}
