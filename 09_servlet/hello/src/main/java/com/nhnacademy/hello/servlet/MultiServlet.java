package com.nhnacademy.hello.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "multiServlet", value = "/multi-servlet")
public class MultiServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(MultiServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] values = req.getParameterValues("class");
        String url = getServletContext().getInitParameter("url");

        try (PrintWriter out = resp.getWriter()) {
            out.println(String.join(",", values));
            out.printf("url:%s\n", url);
        } catch (IOException e) {
            log.info(e.getMessage());
        }
    }
}
