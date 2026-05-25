package model;

import enums.AttendanceStatus;
import interfacepkg.Displayable;
import java.time.LocalDate;

public class AttendanceRecord implements Displayable {
    private String recordId;
    private Student student;
    private Course course;
    private LocalDate attendanceDate;
    private AttendanceStatus status;

    public AttendanceRecord(String recordId, Student student, Course course, LocalDate attendanceDate, AttendanceStatus status) {
        this.recordId = recordId;
        this.student = student;
        this.course = course;
        this.attendanceDate = attendanceDate;
        this.status = status;
    }

    public String getRecordId() {
        return recordId;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public LocalDate getAttendanceDate() {
        return attendanceDate;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    public void setStatus(AttendanceStatus status) {
        if (status != null) {
            this.status = status;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Record ID: " + recordId);
        System.out.println("Student: " + student.getName());
        System.out.println("Course: " + course.getCourseName());
        System.out.println("Date: " + attendanceDate);
        System.out.println("Status: " + status);
    }

    @Override
    public String toString() {
        return "Record{student=" + student.getName()
                + ", course=" + course.getCourseName()
                + ", date='" + attendanceDate + "'"
                + ", status=" + status + "}";
    }
}
