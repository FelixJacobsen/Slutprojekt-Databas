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


    @OneToMany
    private List<Course> courseList = new ArrayList<>();

    @OneToMany
    private List<Student> studentList = new ArrayList<>();


    private String educationName;
    private int participants;

    public Education(String educationName, int participants) {
        this.educationName = educationName;
        this.participants = participants;
    }



    public Education() {

    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course course) {
        courseList.add(course);
        course.setEducation(this);
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

    public List<Student> getStudentList(){
        return studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
        student.setEducation(this);
    }

    @Override
    public String toString() {
        return "Education{" +
                "educationID=" + educationID +
                ", courseList=" + courseList +
                ", studentList=" + studentList +
                ", educationName='" + educationName + '\'' +
                ", participants=" + participants +
                '}';
    }
}
