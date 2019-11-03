package spring.cloud.demo.spring.gateway.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 自定义路由配置实体类
 * @auther: fujie.feng
 * @DateT: 2019-11-03
 */
@Data
public class GatewayRouteEntity {

    //主键
    private Long id;
    //创建时间
    private Date createDate;
    //修改时间
    private Date updateDate;

    //路由id
    private String routeId;
    //uri
    private String uri;
    //优先级
    private int order = 0;
    //predicates
    private List<GatewayPredicateEntity> predicates;
    //filters
    private List<GatewayFilterEntity> filters;
}
