package org.example.def.teacher;

import org.example.def.course.Course;

import javax.persistence.*;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teacherID;

    @ManyToOne
    private Course course;

    private String fullName;
    private int age;

    public Teacher(Course course, String fullName, int age) {
        this.course = course;
        this.fullName = fullName;
        this.age = age;
    }

    public Teacher() {

    }

    public long getTeacherID() {
        return teacherID;
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
