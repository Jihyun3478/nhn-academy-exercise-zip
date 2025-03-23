package com.nhnacademy.filter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.nhnacademy.request.Request;
import com.nhnacademy.response.AdminPageResponse;
import com.nhnacademy.response.MyPageResponse;
import com.nhnacademy.response.NotFoundResponse;
import com.nhnacademy.response.OrderPageResponse;

public class FilterChain {
    private List<Filter> filters = new LinkedList<>();
    private Iterator iterator;

    public void addFilter(Filter filter) {
        this.filters.add(filter);
        iterator = filters.iterator();
    }

    public void doFilter(Request request) {
        if (iterator.hasNext()) {
            Filter nextFilter = (Filter)iterator.next();
            nextFilter.doFilter(request, this);
        } else {
            if (request.getPath().equals("/mypage")) {
                new MyPageResponse().doResponse(request);
            } else if (request.getPath().equals("/admin")) {
                new AdminPageResponse().doResponse(request);
            } else if (request.getPath().equals("/order")) {
                new OrderPageResponse().doResponse(request);
            } else if (request.getPath().equals("/main")) {
                new NotFoundResponse().doResponse(request);
            }
        }
    }
}
