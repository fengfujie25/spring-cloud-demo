package spring.cloud.demo.spring.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @auther: fujie.feng
 * @DateT: 2019-10-24
 */
@Configuration
public class BeanConfig {

//    @Bean
//    public KeyResolver hostAddrKeyResolver() {
//        System.out.println("host resolver");
//        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
//    }

    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
