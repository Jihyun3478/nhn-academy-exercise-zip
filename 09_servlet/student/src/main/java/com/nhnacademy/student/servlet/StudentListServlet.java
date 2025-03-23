package com.nhnacademy.student.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nhnacademy.student.model.domain.Student;
import com.nhnacademy.student.repository.StudentRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebServlet(name = "studentListServlet", urlPatterns = "/student/list")
public class StudentListServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) {
        studentRepository = (StudentRepository)config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = new ArrayList<>(studentRepository.getStudents());
        req.setAttribute("studentList", studentList);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/student/list.jsp");
        rd.forward(req, resp);
    }
}
