package com.nhnacademy.hello.util;

import java.util.Optional;

import jakarta.servlet.ServletContext;

public final class CounterUtils {
    private CounterUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static void increaseCounter(ServletContext servletContext) {
        Long counter = Optional.ofNullable((Long)servletContext.getAttribute("counter")).orElse(0L);
        counter = counter + 1;
        servletContext.setAttribute("counter",  counter);
    }
}
