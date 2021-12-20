package org.example.commands;

import org.example.def.course.Course;
import org.example.def.course.CourseImpl;
import org.example.def.education.EducationImpl;
import org.example.def.student.StudentImpl;
import org.example.def.teacher.Teacher;
import org.example.def.teacher.TeacherImpl;

import java.util.List;
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
                [2] Show specific information about a teacher
                [3] Show all teachers
                [4] Delete a teacher
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
                case "2" -> showInformation();
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
       teacherDao.insert(teacher);


        System.out.println("Do you want to add the teacher to a course [y/n] ");
        if(scanner.nextLine().equalsIgnoreCase("y")){
            System.out.println("Add the teacher to a course, this is a list of all current courses: ");
            courseDao.getAll().forEach(System.out::println);

            System.out.println("Enter the course ID that you want to add the teacher to");
            int courseID = Integer.parseInt(scanner.nextLine());

                Course course = courseDao.getById(courseID);
                course.addTeacher(teacher);
                courseDao.update(course);
        }


    }
    private void removeTeacher() {
        System.out.println("Enter id of the teacher you want to remove");
        int teacherId = Integer.parseInt(scanner.nextLine());

        Teacher teacher = teacherDao.getById(teacherId);
        List<Course> courseList = courseDao.getByTeacher(teacher);
        courseList.forEach(course -> course.getTeacherList().remove(teacher));
        courseList.forEach(courseDao::update);
        teacherDao.delete(teacher);
        System.out.println("Teacher removed");
    }

    private void showAllTeachers() {
        teacherDao.getAll().forEach(System.out::println);
    }



    private void showInformation() {
        System.out.println("Enter id of the teacher you want to show");
        int teacherId = Integer.parseInt(scanner.nextLine());

        Teacher teacher = teacherDao.getById(teacherId);


    }




}
