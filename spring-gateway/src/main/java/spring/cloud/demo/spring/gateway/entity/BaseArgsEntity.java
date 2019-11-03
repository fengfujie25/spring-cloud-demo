package spring.cloud.demo.spring.gateway.entity;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

/**
 * @auther: fujie.feng
 * @DateT: 2019-11-03
 */
@Data
public class BaseArgsEntity {

    private String name;

    private Map<String, String> args = Maps.newLinkedHashMap();
}
