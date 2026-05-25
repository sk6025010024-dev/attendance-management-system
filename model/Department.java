package model;

import interfacepkg.Displayable;

public class Department implements Displayable {
    private String departmentId;
    private String departmentName;

    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (departmentName != null && !departmentName.isEmpty()) {
            this.departmentName = departmentName;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Department ID: " + departmentId);
        System.out.println("Department Name: " + departmentName);
    }

    @Override
    public String toString() {
        return departmentName;
    }
}
