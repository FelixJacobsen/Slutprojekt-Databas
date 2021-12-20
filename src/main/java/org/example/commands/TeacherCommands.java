package org.example.commands;

import org.example.def.course.Course;
import org.example.def.course.CourseImpl;
import org.example.def.education.EducationImpl;
import org.example.def.student.StudentImpl;
import org.example.def.teacher.Teacher;
import org.example.def.teacher.TeacherImpl;

import java.util.Scanner;

public class TeacherCommands {
    CourseImpl courseDao = new CourseImpl();
    EducationImpl educationDao = new EducationImpl();
    StudentImpl studentDao = new StudentImpl();
    TeacherImpl teacherDao = new TeacherImpl();


    Scanner scanner = new Scanner(System.in);



    private void teacherMenu(){
        System.out.println("""
                [0] Exit teacher menu
                [1] Add a new teacher
                [2] Delete teacher
                [3] Update teacher
                [4] Show specific teacher
                [5] Show all teachers
                """);
    }


    public void teacherMenuOptions(){
        boolean flag = true;
        String choice;
        while(flag){
            teacherMenu();
            choice = scanner.nextLine();
            switch (choice) {
                case "0" -> {
                    System.out.println("Exiting education menu");
                    flag = false;
                }
                case "1" -> addTeacher();
                case "2" -> updateTeacher();
                case "3" -> showAllTeachers();
                case "4" -> removeTeacher();
            }
        }


    }
    private void addTeacher() {
        System.out.println("Enter teachers full name:");
        String fullName = scanner.nextLine();

        System.out.println("Enter teacher age: ");
        int age = Integer.parseInt(scanner.nextLine());

       Teacher teacher = new Teacher(fullName,age);

        System.out.println("Add the teacher to a course, this is a list of all current courses: ");
        courseDao.getAll().forEach(System.out::println);

        System.out.println("Enter the course ID that you want to add the teacher to");
        int courseID = Integer.parseInt(scanner.nextLine());

        System.out.println("type e");
        String typeE = scanner.nextLine();
        if(typeE.equalsIgnoreCase("")){
            Course course = courseDao.getById(courseID);
            teacher.addCourse(course);
            courseDao.update(course);
        }




    }
    private void removeTeacher() {


        System.out.println("Enter id of the teacher you want to remove");
        int teacherId = Integer.parseInt(scanner.nextLine());

        Teacher teacher = teacherDao.getById(teacherId);
        teacherDao.delete(teacher);

        System.out.println("Teacher removed");


    }

    private void showAllTeachers() {

        teacherDao.getAll().forEach(System.out::println);
    }



    private void updateTeacher() {
        System.out.println("Enter id of the teacher you want to update");
        int teacherId = Integer.parseInt(scanner.nextLine());

        Teacher teacher = teacherDao.getById(teacherId);


    }




}
