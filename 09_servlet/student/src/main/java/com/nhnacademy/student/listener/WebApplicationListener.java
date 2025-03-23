package com.nhnacademy.student.listener;

import java.util.Random;

import com.nhnacademy.student.model.domain.Student;
import com.nhnacademy.student.model.domain.type.Gender;
import com.nhnacademy.student.repository.MapStudentRepository;
import com.nhnacademy.student.repository.StudentRepository;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class WebApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        StudentRepository studentRepository = new MapStudentRepository();
        ServletContext context = sce.getServletContext();

        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            Student student = new Student.StudentBuilder()
                .id("student" + i)
                .name("아카데미" + i)
                .gender(Gender.values()[random.nextInt(2)])
                .age(random.nextInt(20, 31))
                .build();

            studentRepository.save(student);
        }
        context.setAttribute("studentRepository", studentRepository);
    }
}
