package com.linxingwu.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Component
public class PostErrorFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(PostErrorFilter.class);
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
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
        dosomething();
        return null;
    }

    private void dosomething() {
        logger.info("filter running");
        throw new RuntimeException("Exception in post");
    }
}
