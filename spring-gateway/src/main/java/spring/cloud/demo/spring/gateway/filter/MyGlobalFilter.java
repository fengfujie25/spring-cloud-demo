package spring.cloud.demo.spring.gateway.filter;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * 全局过滤器
 * 校验token
 * @auther: fujie.feng
 * @DateT: 2019-10-21
 */
public class MyGlobalFilter implements GlobalFilter, Ordered {

    private static final String TOKEN = "token";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String parm = exchange.getRequest().getQueryParams().getFirst(TOKEN);
        if (StringUtils.isBlank(parm)) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
