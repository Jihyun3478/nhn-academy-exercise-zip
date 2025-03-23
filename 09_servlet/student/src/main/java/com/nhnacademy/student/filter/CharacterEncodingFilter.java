package com.nhnacademy.student.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

@WebFilter(
    filterName = "characterEncodingFilter",
    urlPatterns = "/*",
    initParams = {
        @WebInitParam(name = "encoding", value = "UTF-8")
    }
)
public class CharacterEncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
        IOException,
        ServletException {
        servletRequest.setCharacterEncoding(this.encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
