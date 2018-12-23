package cn.zgc.spring.security.demo.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 在Spring Boot中，Filter交给Spring容器管理（类上添加@Component注解）了就能生效，但无法指定拦截路径。
 * 如果需要指定拦截路径，或者使用第三方的Filter（无法添加@Componet注解），此时需要通过配置来完成
 * 相关配置请参见：config/WebConfig.java
 */
//@Component
public class TimeFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TimeFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("TimeFilter doFilter");
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("【Filter】耗时;"+(System.currentTimeMillis()-startTime));
    }

    @Override
    public void destroy() {
        System.out.println("TimeFilter destory");
    }
}
