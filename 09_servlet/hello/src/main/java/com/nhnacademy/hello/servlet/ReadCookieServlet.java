package com.nhnacademy.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import com.nhnacademy.hello.util.CookieUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "readCookieServlet", value = "/read-cookie")
public class ReadCookieServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(ReadCookieServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.getCookie(req, "locale");

        if (Objects.isNull(cookie)) {
            resp.sendError(500, "cookie not found");
            return;
        }

        String locale = cookie.getValue();

        String helloValue = ResourceBundle.getBundle("message", new Locale(locale)).getString("hello");
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = resp.getWriter()) {
            writer.println(helloValue);
        }
    }
}
