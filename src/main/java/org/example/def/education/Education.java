package org.example.def.education;

import org.example.def.course.Course;
import org.example.def.student.Student;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationID;
    private String educationName;
    private int participants;

    public Education(String educationName, int participants) {
        this.educationName = educationName;
        this.participants = participants;
    }

    public Education() {

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

    @Override
    public String toString() {
        return "Education{" +
                "educationID=" + educationID +
                ", educationName='" + educationName + '\'' +
                ", participants=" + participants +
                '}';
    }
}
