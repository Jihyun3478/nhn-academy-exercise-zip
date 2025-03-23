package com.nhnacademy.member;

public class Member {
    private String name;
    private String id;
    private String password;
    private Role role;

    public Member(String name, String id, String password, Role role) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public boolean hasRole(Role role) {
        return this.role == role;
    }

    public static Member createUncertifiedMember(String name, String id, String password) {
        return new Member(name, id, password, Role.NONE);
    }

    public static Member createUser(String name, String id, String password) {
        return new Member(name, id, password, Role.USER);
    }

    public static Member createManager(String name, String id, String password) {
        return new Member(name, id, password, Role.MANAGER);
    }

    public static Member createAdmin(String name, String id, String password) {
        return new Member(name, id, password, Role.ADMIN);
    }
}
