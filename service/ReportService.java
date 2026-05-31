package service;

import enums.AttendanceStatus;
import model.AttendanceRecord;
import model.Student;
import model.Course;import java.util.ArrayList;

public class ReportService {

    private AttendanceService attendanceService;

    public ReportService(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }
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

    public double calculateAttendancePercentage(Student student) {
        ArrayList<AttendanceRecord> records = attendanceService.getRecords(student);
        return calculateAttendancePercentage(records);
    }

    public double calculateAttendancePercentage(Student student, Course course) {
        ArrayList<AttendanceRecord> studentRecords = attendanceService.getRecords(student);
        ArrayList<AttendanceRecord> courseRecords = new ArrayList<>();
        for (AttendanceRecord r : studentRecords) {
            if (r.getCourse().equals(course)) {
                courseRecords.add(r);
            }
        }
        return calculateAttendancePercentage(courseRecords);
    }

    public void printStudentReport(Student student, ArrayList<AttendanceRecord> records) {
        System.out.println("Attendance Report for " + student.getName());
        System.out.println("Total Records: " + records.size());
        System.out.println("Present: " + countPresent(records));
        System.out.println("Absent: " + countAbsent(records));
        System.out.println("Late: " + countLate(records));
        System.out.println("Attendance Percentage: " + calculateAttendancePercentage(records) + "%");
    }

    public void printStudentReport(Student student) {
        ArrayList<AttendanceRecord> records = attendanceService.getRecords(student);
        printStudentReport(student, records);
    }

    public void printStudentReport(Student student, Course course) {
        ArrayList<AttendanceRecord> studentRecords = attendanceService.getRecords(student);
        ArrayList<AttendanceRecord> courseRecords = new ArrayList<>();
        for (AttendanceRecord r : studentRecords) {
            if (r.getCourse().equals(course)) {
                courseRecords.add(r);
            }
        }
        System.out.println("Attendance Report for " + student.getName() + " in " + course.getCourseName());
        System.out.println("Total Records: " + courseRecords.size());
        System.out.println("Present: " + countPresent(courseRecords));
        System.out.println("Absent: " + countAbsent(courseRecords));
        System.out.println("Late: " + countLate(courseRecords));
        System.out.println("Attendance Percentage: " + calculateAttendancePercentage(courseRecords) + "%");
    }
}
