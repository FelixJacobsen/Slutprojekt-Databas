package org.example.def.course;

import org.example.def.education.Education;
import org.example.def.student.Student;
import org.example.def.teacher.Teacher;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;

    @ManyToMany(targetEntity = Teacher.class)
    private List<Teacher> teacherList;

    @ManyToOne
    private Education education;


    public Course(List<Teacher> teacherList, Education education, String courseName, String courseLanguage, Date startDate, Date endDate) {
        this.teacherList = teacherList;
        this.education = education;
        this.courseName = courseName;
        this.courseLanguage = courseLanguage;
        this.startDate = startDate;
        this.endDate = endDate;
    }



    private String courseName;
    private String courseLanguage;
    private Date startDate;
    private Date endDate;

    public Course() {

    }

    public Education getEducation() {
        return education;
    }


    public Long getCourseID() {
        return courseID;
    }


    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseLanguage() {
        return courseLanguage;
    }

    public void setCourseLanguage(String courseLanguage) {
        this.courseLanguage = courseLanguage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
