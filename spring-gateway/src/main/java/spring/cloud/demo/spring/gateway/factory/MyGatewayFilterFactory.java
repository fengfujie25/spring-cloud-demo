package spring.cloud.demo.spring.gateway.factory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;

/**
 * 自定义过滤器工厂
 *
 * @auther: fujie.feng
 * @DateT: 2019-10-21
 */
@Slf4j
public class MyGatewayFilterFactory extends AbstractGatewayFilterFactory<MyGatewayFilterFactory.Config> {

//    private static final Log log = LogFactory.getLog(MyGatewayFilterFactory.class);

    private static final String PARAMS = "myParams";

    private static final String START_TIME = "startTime";

    public MyGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList(PARAMS);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            exchange.getAttributes().put(START_TIME, System.currentTimeMillis());
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        Long startTime = exchange.getAttribute(START_TIME);
                        if (startTime == null) {
                            return;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("exchange request uri:" + exchange.getRequest().getURI() + ",");
                        sb.append("Time:" + (System.currentTimeMillis() - startTime) + "ms.");
                        if (config.isMyParams()) {
                            sb.append("params:" + exchange.getRequest().getQueryParams());
                        }
                        log.info("gateway MyGatewayFilterFactory :" + sb.toString());
                    })
            );
        });
    }

    /**
     * 配置参数类
     */
    public static class Config {

        private boolean myParams;

        public boolean isMyParams() {
            return myParams;
        }

        public void setMyParams(boolean myParams) {
            this.myParams = myParams;
        }
    }
}
