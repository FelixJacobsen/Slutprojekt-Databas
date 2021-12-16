package org.example.def.education;

import org.example.daointerfaces.Dao;
import org.example.def.course.Course;

import java.util.List;

public interface EducationDao extends Dao<Education> {
    List<Education> getEducationName(String name);
    List<Education> getEducationId(long Id);
    List<Education> getByParticipants(int participants);
    List<Education> getCourses(Course course);
}
