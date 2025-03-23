package com.nhnacademy.student.repository;

import java.util.List;

import com.nhnacademy.student.exception.StudentAlreadyExistException;
import com.nhnacademy.student.exception.StudentNotFoundException;
import com.nhnacademy.student.model.domain.Student;

public interface StudentRepository {
    void save(Student student);

    void update(Student student);

    void deleteById(String id);

    Student getStudentById(String id);

    List<Student> getStudents();

    boolean existById(String id);

    default void validateExist(String id) {
        if (existById(id)) {
            throw new StudentAlreadyExistException("Student already exist!");
        }
    }

    default void validateNotExist(String id) {
        if (!existById(id)) {
            throw new StudentNotFoundException("Student not found!");
        }
    }
}
