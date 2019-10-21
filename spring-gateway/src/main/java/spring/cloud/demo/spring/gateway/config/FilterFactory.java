package spring.cloud.demo.spring.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.cloud.demo.spring.gateway.factory.MyGatewayFilterFactory;

/**
 * @auther: fujie.feng
 * @DateT: 2019-10-21
 */
@Configuration
public class FilterFactory {

    @Bean
    public MyGatewayFilterFactory myGatewayFilterFactory() {
        return new MyGatewayFilterFactory();
    }
}
