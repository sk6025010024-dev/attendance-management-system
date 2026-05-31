package model;

import enums.Role;

public class Student extends User {
    private String studentId;
    private Major major;
    private Section section;

    public Student(String userId, String name, String email, String studentId, Major major, Section section) {
        super(userId, name, email, Role.STUDENT);
        this.studentId = studentId;
        this.major = major;
        this.section = section;
    }

    public String getStudentId() {
        return studentId;
    }

    public Major getMajor() {
        return major;
    }

    public Section getSection() {
        return section;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
        System.out.println("Major: " + major.getMajorName());
        System.out.println("Section: " + section.getSectionName());
    }

    @Override
    public String toString() {
        return studentId + " - " + getName();
    }
}
