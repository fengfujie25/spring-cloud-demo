//package spring.cloud.demo.spring.gateway.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import spring.cloud.demo.spring.gateway.filter.MyGatewayFilter;
//import spring.cloud.demo.spring.gateway.filter.MyGlobalFilter;
//
///**
// * @auther: fujie.feng
// * @DateT: 2019-10-12
// */
//@Configuration
//public class RoutesConfig {
//
//    /**
//     * 全局filter
//     * @return
//     */
//    @Bean
//    public MyGlobalFilter myGlobalFilter() {
//        return new MyGlobalFilter();
//    }
//
//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
//        return routeLocatorBuilder.routes().route(r -> r.path("/ribbon/**")
//                .filters(f -> f.stripPrefix(1)
//                        .filter(new MyGatewayFilter()) //增加自定义filter
//                        .addRequestHeader("X-Response-Default-Foo", "Default-Bar"))
//                .uri("lb://EUREKA-RIBBON")
//                .order(0)
//                .id("ribbon-route")
//        ).build();
//    }
//}
