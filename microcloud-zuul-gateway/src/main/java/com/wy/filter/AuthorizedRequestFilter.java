package com.wy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.security.auth.login.Configuration;
import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author wangyang
 * @date 2020/8/28 20:27
 * @description:
 */
public class AuthorizedRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        //做权限验证，所以应该接受请求前过滤
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("添加认证信息");
        // 获取当前请求的上下文
        RequestContext currentContext = RequestContext.getCurrentContext() ;
        // 认证的原始信息
        String auth = "admin:123456";
        // 进行一个加密的处理
        byte[] encodedAuth = Base64.getEncoder()
                .encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String(encodedAuth);
        currentContext.addZuulRequestHeader("Authorization", authHeader);
        return null;
    }
}
