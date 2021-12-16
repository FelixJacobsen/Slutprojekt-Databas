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

    @OneToMany
    private List<Course> course;

    @ManyToOne
    private Education education;

    private int age;
    private String fullName;


    public Student() {
    }






}
