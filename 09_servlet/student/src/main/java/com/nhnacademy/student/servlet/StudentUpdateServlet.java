package com.nhnacademy.student.servlet;

import java.io.IOException;
import java.util.Objects;

import com.nhnacademy.student.exception.StudentNotFoundException;
import com.nhnacademy.student.model.domain.Student;
import com.nhnacademy.student.model.domain.type.Gender;
import com.nhnacademy.student.repository.StudentRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "studentUpdateServlet", urlPatterns = "/student/update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) {
        studentRepository = (StudentRepository)config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO: 같은 코드가 계속 중복됨 -> 이래서 FrontendServlet 도입 필요
        String id = req.getParameter("id");
        String action = "/student/update";
        String buttonText = "수정";
        Student student = null;

        if (id != null && !id.isEmpty()) {
            student = studentRepository.getStudentById(id);
            if (student != null) {
                action = "/student/update";
                buttonText = "수정";
            }
        }

        req.setAttribute("student", student);
        req.setAttribute("action", action);
        req.setAttribute("buttonText", buttonText);

        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/student/register.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String age = req.getParameter("age");

        if (Objects.isNull(id) || Objects.isNull(name) || Objects.isNull(gender) || Objects.isNull(age)) {
            throw new StudentNotFoundException("Student not found!");
        }

        Student student = new Student.StudentBuilder()
            .id(id)
            .name(name)
            .gender(Gender.getGender(gender))
            .age(Integer.parseInt(age))
            .build();
        studentRepository.update(student);

        resp.sendRedirect("/student/view?id=" + student.getId());
    }
}
