package com.nhnacademy.student.model.domain;

import java.time.LocalDateTime;

import com.nhnacademy.student.model.domain.type.Gender;

import lombok.Getter;

@Getter
public class Student {
    private String id;
    private String name;
    private Gender gender;
    private int age;
    private LocalDateTime createdAt;

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.gender = builder.gender;
        this.age = builder.age;
        this.createdAt = LocalDateTime.now();
    }

    public static class StudentBuilder {
        private String id;
        private String name;
        private Gender gender;
        private int age;

        public StudentBuilder id(String id) {
            this.id = id;
            return this;
        }

        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder gender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public StudentBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
