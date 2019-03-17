package com.yh.line.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * 自定义错误过滤器
 * Created by yanghua on 2019/3/17.
 */
@Component
public class ErrorFilter extends ZuulFilter{
    @Override
    public String filterType() {
        return "error";
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
        Throwable e = ctx.getThrowable();
        // 如下设置，可以让zuul的SendErrorFilter过滤器处理错误并返回错误信息
        ctx.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        ctx.set("error.message", "测试错误返回");
        ctx.set("error.exception", e);

        return null;
    }
}
