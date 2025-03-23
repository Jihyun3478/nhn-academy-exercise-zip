package com.nhnacademy.filter;

import com.nhnacademy.request.Request;

public interface Filter {
    void doFilter(Request request, FilterChain filterChain);
}
