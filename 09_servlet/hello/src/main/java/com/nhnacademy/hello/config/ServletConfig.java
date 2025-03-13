package com.nhnacademy.hello.config;

import java.util.Enumeration;

import jakarta.servlet.ServletContext;

public interface ServletConfig {
    String getServletName();

    String getInitParameter(String name);

    Enumeration<String> getInitParameterNames();

    ServletContext getServletContext();
}
