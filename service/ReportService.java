package service;

import enums.AttendanceStatus;
import model.AttendanceRecord;
import model.Student;

import java.util.ArrayList;

public class ReportService {

    public int countPresent(ArrayList<AttendanceRecord> records) {
        int count = 0;
        for (AttendanceRecord record : records) {
            if (record.getStatus() == AttendanceStatus.PRESENT) {
                count++;
            }
        }
        return count;
    }

    public int countAbsent(ArrayList<AttendanceRecord> records) {
        int count = 0;
        for (AttendanceRecord record : records) {
            if (record.getStatus() == AttendanceStatus.ABSENT) {
                count++;
            }
        }
        return count;
    }

    public int countLate(ArrayList<AttendanceRecord> records) {
        int count = 0;
        for (AttendanceRecord record : records) {
            if (record.getStatus() == AttendanceStatus.LATE) {
                count++;
            }
        }
        return count;
    }

    public double calculateAttendancePercentage(ArrayList<AttendanceRecord> records) {
        if (records == null || records.isEmpty()) {
            return 0;
        }
        int presentCount = countPresent(records);
        return (presentCount * 100.0) / records.size();
    }

    public void printStudentReport(Student student, ArrayList<AttendanceRecord> records) {
        System.out.println("Attendance Report for " + student.getName());
        System.out.println("Total Records: " + records.size());
        System.out.println("Present: " + countPresent(records));
        System.out.println("Absent: " + countAbsent(records));
        System.out.println("Late: " + countLate(records));
        System.out.println("Attendance Percentage: " + calculateAttendancePercentage(records) + "%");
    }
}
