package service;

import enums.AttendanceStatus;
import model.AttendanceRecord;
import model.Course;
import model.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class AttendanceService {
    private ArrayList<AttendanceRecord> records;

    public AttendanceService() {
        records = new ArrayList<>();
    }

    public void markAttendance(AttendanceRecord record) {
        if (record != null) {
            records.add(record);
        }
    }

    public ArrayList<AttendanceRecord> getAllRecords() {
        return records;
    }

    public void markAttendance(Student student, Course course, LocalDate date, AttendanceStatus status) {
        String recordId = "R" + System.currentTimeMillis();
        AttendanceRecord record = new AttendanceRecord(recordId, student, course, date, status);
        records.add(record);
    }

    public void markAttendance(String studentId, String courseCode, LocalDate date, AttendanceStatus status) {
        System.out.println("Note: markAttendance by String IDs requires database lookup for " + studentId + " and " + courseCode + ".");
        System.out.println("[Database lookup simulated. Record would be added here.]");
    }

    public ArrayList<AttendanceRecord> getRecords(Student student) {
        ArrayList<AttendanceRecord> result = new ArrayList<>();
        for (AttendanceRecord record : records) {
            if (record.getStudent().equals(student)) {
                result.add(record);
            }
        }
        return result;
    }

    public ArrayList<AttendanceRecord> getRecords(Course course) {
        ArrayList<AttendanceRecord> result = new ArrayList<>();
        for (AttendanceRecord record : records) {
            if (record.getCourse().equals(course)) {
                result.add(record);
            }
        }
        return result;
    }

    public ArrayList<AttendanceRecord> getRecords(LocalDate date) {
        ArrayList<AttendanceRecord> result = new ArrayList<>();
        for (AttendanceRecord record : records) {
            if (record.getAttendanceDate().equals(date)) {
                result.add(record);
            }
        }
        return result;
    }

    public int countByStatus(AttendanceStatus status) {
        int count = 0;
        for (AttendanceRecord record : records) {
            if (record.getStatus() == status) {
                count++;
            }
        }
        return count;
    }
}
