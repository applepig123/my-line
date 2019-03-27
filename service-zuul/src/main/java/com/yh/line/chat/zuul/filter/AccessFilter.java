package com.yh.line.chat.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanghua on 2019/3/17.
 */
public class AccessFilter extends ZuulFilter{
    /**
     * 过滤器的类型，决定过滤器在请求的哪个声明周期中执行
     * pre 请求被路由之前调用
     * routing 在路由请求时被调用
     * post 在routing和error过滤器之后被调用
     * error 处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 用于决定多个过滤器的执行顺序，越小优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断过滤器是否需要执行，指定过滤的有效范围
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getHeader("access-token");
        if(token == null) {
            System.err.println("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        System.out.println("token is ok");
        return null;
    }
}
