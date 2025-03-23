package com.nhnacademy.hello.filter;

import com.nhnacademy.hello.request.Request;

public interface Filter {
    void doFilter(Request request, FilterChain filterChain);
}
