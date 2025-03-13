package com.nhnacademy.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.logging.Logger;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "setCookieServlet", value = "/set-cookie")
public class SetCookieServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(SetCookieServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String locale = req.getParameter("locale");

        if (Objects.isNull(locale)) {
            locale = "ko";
        }

        Cookie cookie = new Cookie("locale", locale);
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        resp.addCookie(cookie);

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("OK");
        }
    }
}
