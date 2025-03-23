package com.nhnacademy.student.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.nhnacademy.student.model.domain.Student;

public class MapStudentRepository implements StudentRepository {
    private final Map<String, Student> studentsMap = new ConcurrentHashMap<>();

    @Override
    public void save(Student student) {
        validateExist(student.getId());
        studentsMap.put(student.getId(), student);
    }

    @Override
    public void update(Student student) {
        validateNotExist(student.getId());
        studentsMap.replace(student.getId(), student);
    }

    @Override
    public void deleteById(String id) {
        validateNotExist(id);
        studentsMap.remove(id);
    }

    @Override
    public Student getStudentById(String id) {
        validateNotExist(id);
        return studentsMap.get(id);
    }

    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(studentsMap.values());
    }

    @Override
    public boolean existById(String id) {
        return studentsMap.get(id) != null;
    }
}
