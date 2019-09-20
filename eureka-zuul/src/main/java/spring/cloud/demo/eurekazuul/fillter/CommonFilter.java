package spring.cloud.demo.eurekazuul.fillter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auther: fujie.feng
 * @DateT: 2019-09-17
 */
public class CommonFilter extends ZuulFilter {

    /**
     * 在请求被路由之前调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否执行该过滤器，此处为true，说明需要过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //获取请求参数
        String token = request.getParameter("token");

        //如果有token参数并且token值为maomao，才进行路由
        if (StringUtils.isNotBlank(token) && token.equals("maomao")) {
            requestContext.setSendZuulResponse(true);
            requestContext.setResponseStatusCode(200);
            requestContext.set("code", 1);
        } else {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            HttpServletResponse response = requestContext.getResponse();
            response.setHeader("content-type", "text/html;charset=utf-8");
            requestContext.setResponseBody("网关认证失败，停止路由");
            requestContext.set("code", 0);
        }
        return null;
    }
}
