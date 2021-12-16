package org.example.def.student;

import org.example.daointerfaces.Dao;
import org.example.def.course.Course;
import org.example.def.education.Education;

import java.util.List;

public interface StudentDao extends Dao<Student> {
    List<Student> getByName(String name);
    List<Student> getByCourse(Course course);
    List<Student> getByAge(int age);
    List<Student> getByEducation(Education education);
}
