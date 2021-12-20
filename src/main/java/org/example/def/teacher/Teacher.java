package org.example.def.teacher;

import org.example.def.course.Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teacherID;


    private String fullName;
    private int age;

    public Teacher(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public Teacher() {

    }


    public int getTeacherID() {
        return teacherID;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID=" + teacherID +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }
}
