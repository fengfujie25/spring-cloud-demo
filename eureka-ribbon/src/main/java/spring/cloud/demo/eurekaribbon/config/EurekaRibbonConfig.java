package spring.cloud.demo.eurekaribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@Configuration
public class EurekaRibbonConfig {

    @Bean
    @LoadBalanced //实现负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
