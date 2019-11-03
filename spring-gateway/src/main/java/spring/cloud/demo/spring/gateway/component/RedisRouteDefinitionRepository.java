package spring.cloud.demo.spring.gateway.component;

import com.google.common.collect.Lists;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.cloud.gateway.support.NotFoundException;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring.cloud.demo.spring.gateway.redis.RedisUtils;
import spring.cloud.demo.spring.gateway.util.JsonUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @auther: fujie.feng
 * @DateT: 2019-11-03
 */
@Component
public class RedisRouteDefinitionRepository implements RouteDefinitionRepository {

    //存储的的key
    private final static String KEY = "gateway_dynamic_route";

    @Resource
    private RedisUtils redisUtils;

    /**
     * 获取路由信息
     * @return
     */
    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> gatewayRouteEntityList = Lists.newArrayList();
        redisUtils.hgets(KEY).stream().forEach(route -> {
            RouteDefinition result = JsonUtils.parseJson(route.toString(), RouteDefinition.class);
            gatewayRouteEntityList.add(result);
        });
        return Flux.fromIterable(gatewayRouteEntityList);
    }

    /**
     * 新增
     * @param route
     * @return
     */
    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(routeDefinition -> {
            redisUtils.hset(KEY, routeDefinition.getId(), JsonUtils.toString(routeDefinition));
            return Mono.empty();
        });
    }

    /**
     * 删除
     * @param routeId
     * @return
     */
    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            if (redisUtils.hHashKey(KEY, id)) {
                redisUtils.hdel(KEY, id);
                return Mono.empty();
            }
            return Mono.defer(() -> Mono.error(new NotFoundException("route definition is not found, routeId:" + routeId)));
        });
    }
}
