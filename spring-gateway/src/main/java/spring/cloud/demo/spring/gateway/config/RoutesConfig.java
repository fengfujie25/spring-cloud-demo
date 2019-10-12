package spring.cloud.demo.spring.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther: fujie.feng
 * @DateT: 2019-10-12
 */
@Configuration
public class RoutesConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes().route(r -> r.path("/ribbon/**")
                .filters(f -> f.stripPrefix(1)
                        .addRequestHeader("X-Response-Default-Foo", "Default-Bar"))
                .uri("lb://EUREKA-RIBBON")
                .order(0)
                .id("ribbon-route")
        ).build();
    }
}
