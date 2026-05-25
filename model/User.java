package model;

import enums.Role;
import interfacepkg.Displayable;

public class User implements Displayable {
    public static final String SYSTEM_NAME = "Attendance Management System";
    private String userId;
    private String name;
    private String email;
    private Role role;

    public User(String userId, String name, String email, Role role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public void setEmail(String email) {
        if (email != null && !email.isEmpty()) {
            this.email = email;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Role: " + role);
    }

    @Override
    public String toString() {
        return userId + " - " + name + " (" + role + ")";
    }
}
