package org.example.def.course;

import org.example.daointerfaces.Dao;
import org.example.def.student.Student;
import org.example.def.teacher.Teacher;

import java.util.List;

public interface CourseDao extends Dao<Course> {
     List<Course> getByName(String name);
     List<Course> orderByLength();
     List<Course> getByTeacher(Teacher teacher);

}
