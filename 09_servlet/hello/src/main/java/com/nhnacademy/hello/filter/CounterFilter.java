package com.nhnacademy.hello.filter;

import java.io.IOException;

import com.nhnacademy.hello.util.CounterUtils;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CounterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        jakarta.servlet.FilterChain filterChain) throws IOException, ServletException {
        CounterUtils.increaseCounter(servletRequest.getServletContext());
        filterChain.doFilter(servletRequest, servletResponse);
        log.error("counter:{}", servletRequest.getServletContext().getAttribute("counter"));
    }
}
