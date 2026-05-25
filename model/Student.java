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

    // Low risk — admin may correct a typo in enrollment ID
    public void setStudentId(String studentId) {
        if (studentId != null && !studentId.isEmpty()) {
            this.studentId = studentId;
        }
    }

    public Major getMajor() {
        return major;
    }

    // Medium risk — students can change their major
    public void setMajor(Major major) {
        if (major != null) {
            this.major = major;
        }
    }

    public Section getSection() {
        return section;
    }

    // Medium risk — students can move between sections
    public void setSection(Section section) {
        if (section != null) {
            this.section = section;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Major: " + major.getMajorName());
        System.out.println("Section: " + section.getSectionName());
    }

    @Override
    public String toString() {
        return studentId + " - " + getName();
    }
}
