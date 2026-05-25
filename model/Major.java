package model;

import interfacepkg.Displayable;

public class Major implements Displayable {
    private String majorId;
    private String majorName;
    private Department department;

    public Major(String majorId, String majorName, Department department) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.department = department;
    }

    public String getMajorId() {
        return majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setMajorName(String majorName) {
        if (majorName != null && !majorName.isEmpty()) {
            this.majorName = majorName;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Major ID: " + majorId);
        System.out.println("Major Name: " + majorName);
        System.out.println("Department: " + department.getDepartmentName());
    }

    @Override
    public String toString() {
        return majorName + " (" + department + ")";
    }
}
