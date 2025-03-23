package com.nhnacademy.filter;

import java.util.Objects;

import com.nhnacademy.member.Member;
import com.nhnacademy.member.Role;
import com.nhnacademy.request.Request;

public class AdminPageFilter implements Filter {
    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        if (request.getPath().equals("/admin")) {
            Member member = (Member) request.get("member");
            if (Objects.nonNull(member)) {
                if (member.hasRole(Role.ADMIN)) {
                    System.out.println("path:" + request.getPath() + " : has ADMIN");
                    filterChain.doFilter(request);
                } else {
                    System.out.println("path:" + request.getPath() + " : has not ADMIN");
                }
            }
        } else {
            System.out.println("AdminPageCheckFilter : 다음 필터로 넘김!");
            filterChain.doFilter(request);
        }
    }
}
