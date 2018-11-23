package groovy.filter.pre

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext
import com.netflix.zuul.exception.ZuulException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants

import javax.servlet.http.HttpServletRequest

class PreFilter extends ZuulFilter{
    Logger log = LoggerFactory.getLogger(PreFilter.class)
    @Override
    String filterType() {
        return FilterConstants.PRE_TYPE
    }

    @Override
    int filterOrder() {
        return 1000
    }

    @Override
    boolean shouldFilter() {
        return true
    }

    @Override
    Object run() throws ZuulException {
       HttpServletRequest request = RequestContext.getCurrentContext().getRequest()
        log.info("this is a dynamic pre filter : Send {} to {}",request.getMethod(),request.getRequestURL().toString())
        return null
    }
}
