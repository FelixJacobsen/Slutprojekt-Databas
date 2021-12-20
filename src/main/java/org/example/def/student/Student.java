package org.example.def.student;

import org.example.def.course.Course;
import org.example.def.education.Education;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StudentId;


    @ManyToOne
    private Education education;

    private int age;
    private String fullName;


    public Student() {

    }

    public Student(String fullName, int age) {
       this.fullName = fullName;
       this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "StudentId=" + StudentId +
                ", education=" + education +
                ", age=" + age +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
