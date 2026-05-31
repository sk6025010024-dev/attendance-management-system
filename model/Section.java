package model;

import enums.SectionTime;
import interfacepkg.Displayable;

public class Section implements Displayable {
    private String sectionId;
    private String sectionName;
    private Major major;
    private SectionTime sectionTime;

    public Section(String sectionId, String sectionName, Major major, SectionTime sectionTime) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.major = major;
        this.sectionTime = sectionTime;
    }

    public String getSectionId() {
        return sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public Major getMajor() {
        return major;
    }

    public SectionTime getSectionTime() {
        return sectionTime;
    }

    @Override
    public void displayInfo() {
        System.out.println("Section ID: " + sectionId);
        System.out.println("Section Name: " + sectionName);
        System.out.println("Major: " + major.getMajorName());
        System.out.println("Time: " + sectionTime);
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
        return sectionName + " - " + sectionTime;
    }
}
