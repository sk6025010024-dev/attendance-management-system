import enums.AttendanceStatus;
import enums.SectionTime;
import interfacepkg.Displayable;
import model.*;
import service.AttendanceService;
import service.ReportService;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println(User.SYSTEM_NAME);
        System.out.println();

        // --- Setup ---
        Department department = new Department("D001", "Faculty of Software Engineering");
        Major major = new Major("M001", "Software Engineering", department);
        Course course = new Course("C001", "Object Oriented Concept", major);
        Section section = new Section("S001", "SE-Y2-A", major, SectionTime.MORNING);

        Student student1 = new Student(
                "U001", "Dara", "dara@example.com",
                "ST001", major, section
        );

        Student student2 = new Student(
                "U002", "Sokha", "sokha@example.com",
                "ST002", major, section
        );

        Teacher teacher = new Teacher(
                "U003", "Mr. Vathna", "vathna@example.com",
                "T001", department
        );
        teacher.addCourse(course);

        // --- Attendance Records ---
        AttendanceRecord record1 = new AttendanceRecord(
                "R001", student1, course,
                LocalDate.of(2026, 5, 18),
                AttendanceStatus.PRESENT
        );

        AttendanceRecord record2 = new AttendanceRecord(
                "R002", student2, course,
                LocalDate.of(2026, 5, 18),
                AttendanceStatus.ABSENT
        );

        AttendanceService attendanceService = new AttendanceService();
        attendanceService.markAttendance(record1);
        attendanceService.markAttendance(record2);

        // --- Display Info via Displayable interface ---
        System.out.println("===== Department Info =====");
        department.displayInfo();

        System.out.println("\n===== Major Info =====");
        major.displayInfo();

        System.out.println("\n===== Course Info =====");
        course.displayInfo();

        System.out.println("\n===== Section Info =====");
        section.displayInfo();

        System.out.println("\n===== Student Info =====");
        student1.displayInfo();
        System.out.println();
        student2.displayInfo();

        System.out.println("\n===== Teacher Info =====");
        teacher.displayInfo();

        System.out.println("\n===== Attendance Records =====");
        for (AttendanceRecord record : attendanceService.getAllRecords()) {
            record.displayInfo();
            System.out.println();
        }

        // --- Polymorphism demonstration via Displayable ---
        System.out.println("===== Displayable Polymorphism Demo =====");
        ArrayList<Displayable> displayList = new ArrayList<>();
        displayList.add(student1);
        displayList.add(teacher);
        displayList.add(course);
        displayList.add(record1);

        for (Displayable item : displayList) {
            item.displayInfo();
            System.out.println();
        }

        // --- Report ---
        ReportService reportService = new ReportService();
        ArrayList<AttendanceRecord> student1Records = attendanceService.getRecordsByStudent(student1);

        System.out.println("===== Student Report =====");
        reportService.printStudentReport(student1, student1Records);
    }
}
