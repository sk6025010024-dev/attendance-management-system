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

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Admin ID: " + adminId);
    }

    @Override
    public String toString() {
        return adminId + " - " + getName();
    }
}
