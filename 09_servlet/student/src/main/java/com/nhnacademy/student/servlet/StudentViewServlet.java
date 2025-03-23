package com.nhnacademy.student.servlet;

import java.io.IOException;
import java.util.Objects;

import com.nhnacademy.student.exception.StudentNotFoundException;
import com.nhnacademy.student.model.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "studentViewServlet", urlPatterns = "/student/view")
public class StudentViewServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) {
        studentRepository = (StudentRepository)config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (Objects.isNull(id)) {
            throw new StudentNotFoundException("Student not found by id={}" + id);
        }

        Student student = studentRepository.getStudentById(id);
        req.setAttribute("student", student);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/student/view.jsp");
        rd.forward(req, resp);
    }
}
