package com.bar.newtonbar.entity;

public enum RoleType {
    ADMIN("admin"),
    BARMAN("barman"),
    CLIENT("client");

    private String role;

    RoleType(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
