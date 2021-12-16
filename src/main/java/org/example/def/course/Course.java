package org.example.def.course;

import org.example.def.student.Student;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseID;

    @ManyToOne
    private Student student;
    private String courseName;
    private String courseLanguage;
    private Date startDate;
    private Date endDate;









}
