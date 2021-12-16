package org.example.def.course;

import org.example.daointerfaces.Dao;
import org.example.def.student.Student;

import java.util.List;

public interface CourseDao extends Dao<Course> {
     List<Course> getByName(String name);
     List<Course> getById(long id);
     List<Course> getByStudent(Student student);
     List<Course> getByLength(int length);

}
