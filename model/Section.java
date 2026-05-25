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

    // Low risk — section names can be renamed by admin
    public void setSectionName(String sectionName) {
        if (sectionName != null && !sectionName.isEmpty()) {
            this.sectionName = sectionName;
        }
    }

    public Major getMajor() {
        return major;
    }

    public SectionTime getSectionTime() {
        return sectionTime;
    }

    // Medium risk — schedules can change (e.g. morning to afternoon)
    public void setSectionTime(SectionTime sectionTime) {
        if (sectionTime != null) {
            this.sectionTime = sectionTime;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Section ID: " + sectionId);
        System.out.println("Section Name: " + sectionName);
        System.out.println("Major: " + major.getMajorName());
        System.out.println("Time: " + sectionTime);
    }

    @Override
    public String toString() {
        return sectionName + " - " + sectionTime;
    }
}
