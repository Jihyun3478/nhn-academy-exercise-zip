package com.nhnacademy.filter;

import java.util.Objects;

import com.nhnacademy.member.Member;
import com.nhnacademy.member.Role;
import com.nhnacademy.request.Request;

public class OrderPageFilter implements Filter {
    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        if (request.getPath().equals("/order")) {
            Member member = (Member) request.get("member");
            if (Objects.nonNull(member)) {
                if (!member.hasRole(Role.NONE)) {
                    System.out.println("path:" + request.getPath() + " : can order");
                    filterChain.doFilter(request);
                } else {
                    System.out.println("path:" + request.getPath() + " : cannot order");
                }
            }
        } else {
            System.out.println("OrderPageCheckFilter : 다음 필터로 넘김!");
            filterChain.doFilter(request);
        }
    }
}
