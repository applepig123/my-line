package com.yh.line.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by yanghua on 2019/3/17.
 */
public class TestErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return null;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        try {
            doError();
        } catch (Exception e) {
            // 如下设置，可以让zuul的SendErrorFilter过滤器处理错误并返回错误信息
            ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            ctx.set("error.exception", e);
            ctx.set("error.message", "测试错误返回");
        }
        return null;
    }

    void doError() {
        throw new RuntimeException("error");
    }
}
