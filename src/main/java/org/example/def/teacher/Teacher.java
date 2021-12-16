package org.example.def.teacher;

import org.example.def.course.Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teacherID;

    @ManyToMany(targetEntity = Course.class)
    private List<Course> courseList;

    private String fullName;
    private int age;

    public Teacher(List<Course> courseList, String fullName, int age) {
        courseList = new ArrayList<>();
        this.courseList = courseList;
        this.fullName = fullName;
        this.age = age;
    }

    public Teacher() {

    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void addCourse(Course course) {
        courseList.add(course);
       course.getTeacherList().add(this);
    }


    public long getTeacherID() {
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
}
