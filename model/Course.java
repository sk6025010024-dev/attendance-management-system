package model;

import interfacepkg.Displayable;

public class Course implements Displayable {
    private String courseId;
    private String courseName;
    private Major major;

    public Course(String courseId, String courseName, Major major) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.major = major;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public Major getMajor() {
        return major;
    }

    public void setCourseName(String courseName) {
        if (courseName != null && !courseName.isEmpty()) {
            this.courseName = courseName;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Major: " + major.getMajorName());
    }

    public void displayInfo(boolean showStudents) {
        displayInfo();
        if (showStudents) {
            System.out.println("Students: [Student list would be displayed here]");
        }
    }

    public void displayInfo(boolean showStudents, boolean showTeacher) {
        displayInfo(showStudents);
        if (showTeacher) {
            System.out.println("Teacher: [Teacher information would be displayed here]");
        }
    }

    @Override
    public String toString() {
        return courseName;
    }
}
