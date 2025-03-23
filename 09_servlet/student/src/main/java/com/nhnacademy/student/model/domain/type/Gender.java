package com.nhnacademy.student.model.domain.type;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Gender {
    M("man"),
    F("woman"),
    ;

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Gender getGender(String genderName) {
        return Arrays.stream(Gender.values())
            .filter(gender -> gender.getName().equals(genderName))
            .findAny()
            .orElseThrow(() -> new NoSuchElementException("Gender not found!"));
    }
}
