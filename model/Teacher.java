package model;

import enums.Role;
import java.util.ArrayList;

public class Teacher extends User {
    private String teacherId;
    private Department department;
    private ArrayList<Course> courses;

    public Teacher(String userId, String name, String email, String teacherId, Department department) {
        super(userId, name, email, Role.TEACHER);
        this.teacherId = teacherId;
        this.department = department;
        this.courses = new ArrayList<>();
    }

    public String getTeacherId() {
        return teacherId;
    }

    public Department getDepartment() {
        return department;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        if (course != null) {
            courses.add(course);
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Department: " + department.getDepartmentName());
        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println("  - " + course.getCourseName());
        }
    }

    @Override
    public String toString() {
        return teacherId + " - " + getName();
    }
}
