package com.nhnacademy.hello.request;

import com.nhnacademy.hello.filter.AdminPageFilter;
import com.nhnacademy.hello.filter.CounterFilter;
import com.nhnacademy.hello.filter.FilterChain;
import com.nhnacademy.hello.filter.MyPageFilter;
import com.nhnacademy.hello.filter.NotFoundPageFilter;
import com.nhnacademy.hello.filter.OrderPageFilter;

public class HttpRequest {
    private final FilterChain filterChain = new FilterChain();

    public HttpRequest() {
        initFilter();
    }

    public void doRequest(Request request) {
        filterChain.doFilter(request);
    }

    public void initFilter() {
        filterChain.addFilter(new MyPageFilter());
        filterChain.addFilter(new AdminPageFilter());
        filterChain.addFilter(new OrderPageFilter());
        filterChain.addFilter(new NotFoundPageFilter());
    }
}
