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

    public ArrayList<AttendanceRecord> getRecordsByStudent(Student student) {
        ArrayList<AttendanceRecord> result = new ArrayList<>();
        for (AttendanceRecord record : records) {
            if (record.getStudent().equals(student)) {
                result.add(record);
            }
        }
        return result;
    }

    public ArrayList<AttendanceRecord> getRecordsByCourse(Course course) {
        ArrayList<AttendanceRecord> result = new ArrayList<>();
        for (AttendanceRecord record : records) {
            if (record.getCourse().equals(course)) {
                result.add(record);
            }
        }
        return result;
    }

    public ArrayList<AttendanceRecord> getRecordsByDate(LocalDate date) {
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
