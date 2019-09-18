package spring.cloud.demo.eurekazuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.cloud.demo.eurekazuul.fillter.CommonFilter;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@Configuration
public class ZuulFilterConfig {

    @Bean
    public CommonFilter commonFilter() {
        return new CommonFilter();
    }
}
