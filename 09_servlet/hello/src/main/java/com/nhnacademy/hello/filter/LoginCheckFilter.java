package com.nhnacademy.hello.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckFilter implements Filter {
    private final Set<String> excludeUrls = new HashSet<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String urls = filterConfig.getInitParameter("exclude-urls");
        log.error("exclude-urls:{}", urls);
        Arrays.stream(urls.split("\n"))
            .map(String::trim)
            .forEach(excludeUrls::add);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws
        IOException,
        ServletException {
        String requestUri = ((HttpServletRequest)servletRequest).getRequestURI();
        if (!excludeUrls.contains(requestUri)) {
            HttpSession session = ((HttpServletRequest)servletRequest).getSession(false);
            if (Objects.isNull(session)) {
                ((HttpServletResponse)servletResponse).sendRedirect("/login.html");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
