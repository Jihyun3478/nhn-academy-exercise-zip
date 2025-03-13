package com.nhnacademy.hello.util;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public final class CookieUtils {
    private CookieUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static Cookie getCookie(HttpServletRequest req, String name) {
        return Optional.ofNullable(req.getCookies())
            .stream().flatMap(Arrays::stream)
            .filter(c -> c.getName().equals(name))
            .findFirst()
            .orElse(null);
    }
}
