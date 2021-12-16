package org.example.def.student;

import org.example.def.course.Course;
import org.example.def.education.Education;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long StudentId;


    @ManyToOne
    private Education education;

    private int age;
    private String fullName;


    public Student() {

    }

    public Student(Education education, int age, String fullName) {
        this.education = education;
        this.age = age;
        this.fullName = fullName;
    }

    public long getStudentId() {
        return StudentId;
    }


    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
