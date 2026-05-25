package model;

import enums.Role;

public class Admin extends User {
    private String adminId;

    public Admin(String userId, String name, String email, String adminId) {
        super(userId, name, email, Role.ADMIN);
        this.adminId = adminId;
    }

    public String getAdminId() {
        return adminId;
    }

    // Low risk — admin may correct their own ID
    public void setAdminId(String adminId) {
        if (adminId != null && !adminId.isEmpty()) {
            this.adminId = adminId;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin ID: " + adminId);
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
    }

    @Override
    public String toString() {
        return adminId + " - " + getName();
    }
}
