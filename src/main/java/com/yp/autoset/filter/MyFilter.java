package com.yp.autoset.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class MyFilter implements Filter {

    private static final List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        list.add("/favicon.ico");
        HttpServletRequest req = (HttpServletRequest)request;
        if (!list.contains(req.getRequestURI())){
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
