package com.nhnacademy.hello.filter;

import com.nhnacademy.hello.request.Request;

import jakarta.servlet.annotation.WebFilter;

public class NotFoundPageFilter implements Filter {
    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        if (request.getPath().equals("/main")) {
            filterChain.doFilter(request);
        } else {
            System.out.println("NotFoundPageCheckFilter : 다음 필터로 넘김!");
            filterChain.doFilter(request);
        }
    }
}
