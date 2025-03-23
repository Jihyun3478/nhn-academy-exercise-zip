package com.nhnacademy.student.servlet;

import java.io.IOException;
import java.util.Objects;

import com.nhnacademy.student.exception.StudentNotFoundException;
import com.nhnacademy.student.repository.StudentRepository;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "studentDeleteServlet", urlPatterns = "/student/delete")
public class StudentDeleteServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) {
        studentRepository = (StudentRepository)config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");

        if (Objects.isNull(id)) {
            throw new StudentNotFoundException("Student not found by id={}" + id);
        }

        studentRepository.deleteById(id);
        resp.sendRedirect("/student/list");
    }
}
