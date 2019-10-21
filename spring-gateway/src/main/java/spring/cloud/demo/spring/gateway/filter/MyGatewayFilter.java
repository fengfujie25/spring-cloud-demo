package spring.cloud.demo.spring.gateway.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @auther: fujie.feng
 * @DateT: 2019-10-21
 */
public class MyGatewayFilter implements GatewayFilter, Ordered {

    private static final Log log = LogFactory.getLog(MyGatewayFilter.class);

    private static final String TIME = "Time";

    /**
     * 计算请求耗时
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(TIME, System.currentTimeMillis());
        return chain.filter(exchange).then(
                Mono.fromRunnable(() -> {
                    Long start = exchange.getAttribute(TIME);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (start != null) {
                        log.info("exchange request uri:" + exchange.getRequest().getURI() + ", Time:" + (System.currentTimeMillis() - start) + "ms");
                    }
                })
        );
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
