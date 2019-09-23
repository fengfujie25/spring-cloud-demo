package spring.cloud.demo.configclient.controller;

        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.cloud.context.config.annotation.RefreshScope;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${info:error}")
    private String info;

    @RequestMapping("/config/info")
    public String info() {
        return info;
    }

}
