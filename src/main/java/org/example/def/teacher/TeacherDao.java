package org.example.def.teacher;

import org.example.daointerfaces.Dao;
import org.example.def.course.Course;

import java.util.List;

public interface TeacherDao extends Dao<Teacher> {
    List<Teacher> getByName(String name);
    List<Teacher> getByCourse(Course course);
    List<Teacher> orderByAge();
}
