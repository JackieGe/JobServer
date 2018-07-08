package com.job.filter;

import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.FilterChain;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

    public CORSFilter() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

            System.out.println(httpRequest.getServletPath());
        }
        if (servletResponse instanceof HttpServletResponse) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
//            httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
