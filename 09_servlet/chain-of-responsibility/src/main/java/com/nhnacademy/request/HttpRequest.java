package com.nhnacademy.request;

import com.nhnacademy.filter.AdminPageFilter;
import com.nhnacademy.filter.FilterChain;
import com.nhnacademy.filter.MyPageFilter;
import com.nhnacademy.filter.NotFoundPageFilter;
import com.nhnacademy.filter.OrderPageFilter;

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
