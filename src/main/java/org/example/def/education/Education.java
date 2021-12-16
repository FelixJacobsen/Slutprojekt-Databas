package org.example.def.education;

import org.example.def.course.Course;

import javax.persistence.*;
import java.util.List;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationID;


    @OneToMany
    private List<Course> courseList;

    private String educationName;
    private int participants;

    public Education(List<Course> courseList, String educationName, int participants) {
        this.courseList = courseList;
        this.educationName = educationName;
        this.participants = participants;
    }

    public Education() {

    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public int getEducationID() {
        return educationID;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public int getParticipants() {
        return participants;
    }

    public void setParticipants(int participants) {
        this.participants = participants;
    }
}
