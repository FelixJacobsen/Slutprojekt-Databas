package org.example;

import org.example.def.course.CourseImpl;
import org.example.def.education.EducationImpl;
import org.example.def.student.Student;
import org.example.def.teacher.TeacherImpl;

import java.util.Scanner;

public class Menu {
    EducationImpl education = new EducationImpl();
    CourseImpl course = new CourseImpl();
    TeacherImpl teacher = new TeacherImpl();
    Student student = new Student();


    Scanner scanner = new Scanner(System.in);


    private void printer(){
        System.out.println("""
    === School administration system ===
    === The current options are:
        [1]: Change education information
        [2]: Change course information
        [3]: Change student information
        [0]: Quit and exit the program  
    """);
    }

    public void firstOption(String choice){
        boolean flag = true;
        while(flag){
            printer();
            choice = scanner.nextLine();
            switch (choice){
                case "1":
                    educationMenuPrinter();
                    educationMenuOptions();
                    break;
                case "2":
                    courseMenuPrinter();
                    break;
                case "3":
                    studentMenuPrinter();
                    break;
                case "0":
                    System.out.println("Exiting program...");
                    flag = false;
                    break;
            }
        }
    }

    private void educationMenuOptions() {


    }


    public void educationMenuPrinter(){
        System.out.println("""
                ======================================================
                                Enter a choice below
                [0]: Return
                [1]: Add a education
                [2]: Update a current education
                [3]: Show specific information about a education
                [4]: Show all educations
                [5]: Remove a education               
                """);
    }

    public void courseMenuPrinter(){
        System.out.println("""
                =======================================================
                                Enter a choice below
                [0]: Return
                [1]: Add a course
                [2]: Update a existing course
                [3]: Show specific information about a course
                [4]: Show all courses
                [5]: Remove a course
                """);
    }

    public void studentMenuPrinter(){
        System.out.println("""
                =======================================================
                                Enter a choice below
                [0]: Return
                [1]: Add a student
                [2]: Update information about a student
                [3]: Show information about a specific student
                [4]: Show all students
                [5]: Remove a student""");
    }








}
