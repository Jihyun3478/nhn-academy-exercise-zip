package com.nhnacademy.filter;

import java.util.Objects;

import com.nhnacademy.member.Member;
import com.nhnacademy.member.Role;
import com.nhnacademy.request.Request;

public class MyPageFilter implements Filter {
    @Override
    public void doFilter(Request request, FilterChain filterChain) {
        if (request.getPath().equals("/mypage")) {
            Member member = (Member) request.get("member");
            if (Objects.nonNull(member)) {
                if (member.hasRole(Role.USER)) {
                    System.out.println("path:" + request.getPath() + " : has USER");
                    filterChain.doFilter(request);
                } else {
                    System.out.println("path:" + request.getPath() + " : has not USER");
                }
            }
        } else {
            System.out.println("MyPageCheckFilter : 다음 필터로 넘김!");
            filterChain.doFilter(request);
        }
    }
}
