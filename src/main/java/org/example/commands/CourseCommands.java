package org.example.commands;

import org.example.def.course.Course;
import org.example.def.course.CourseDao;
import org.example.def.course.CourseImpl;
import org.example.def.education.Education;
import org.example.def.education.EducationImpl;
import org.example.def.teacher.Teacher;
import org.example.def.teacher.TeacherDao;
import org.example.def.teacher.TeacherImpl;

import java.sql.Date;
import java.util.Scanner;

public class CourseCommands {
    CourseImpl courseDao = new CourseImpl();
    EducationImpl educationDao = new EducationImpl();
    TeacherImpl teacherDao = new TeacherImpl();

    Scanner scanner = new Scanner(System.in);

    public void courseMenuOptions() {
        boolean flag = true;
        String choice;
        while(flag){
            courseMenuPrinter();
            choice = scanner.nextLine();
            switch (choice) {
                case "0" -> {
                    System.out.println("Exiting education menu");
                    flag = false;
                }
                case "1" -> addCourse();
                case "2" -> updateCourse();
                case "3" -> showCourse();
                case "4" -> showAllCourses();
                case "5" -> removeCourse();
            }
        }
    }

    private void addCourse() {
        boolean redo = true;

        do{
            System.out.println("Enter course name: ");
            String courseName = scanner.nextLine();

            System.out.println("Enter course language: ");
            String courseLanguage = scanner.nextLine();

            System.out.println("Enter start date: In this format -> (2000-10-01)");
            String start = scanner.nextLine();
            Date startDate = Date.valueOf(start);

            System.out.println("Enter end date:   In this format -> (2001-01-01)");
            String end = scanner.nextLine();
            Date dateDate = Date.valueOf(end);

            Course course = new Course(courseName,courseLanguage,startDate,dateDate);

            System.out.println("Enter education ID");
            int educationID = Integer.parseInt(scanner.nextLine());

            Education education1 = educationDao.getById(educationID);
            education1.addCourse(course);
            educationDao.update(education1);


            System.out.println("Enter the teachers ID for this course: ");

            int teacherId = Integer.parseInt(scanner.nextLine());

            Teacher teacher1 = teacherDao.getById(teacherId);
            course.addTeacher(teacher1);
            teacherDao.update(teacher1);


            courseDao.insert(course);
            System.out.println("Would you like to add a new course [y/n]");
            String userInput = scanner.nextLine();

            if(userInput.equalsIgnoreCase("n"))
                redo = false;
        }while(redo);
    }


    private void showAllCourses() {
        System.out.println("=====        List of all current courses            =====");
        courseDao.getAll().forEach(System.out::println);
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



    private void removeCourse() {
        System.out.println("Enter ID of the course you want to remove");
        System.out.println("Current courses: " + courseDao.getAll());

        int removeId = Integer.parseInt(scanner.nextLine());


        Course course = courseDao.getById(removeId);
        courseDao.delete(course);
        System.out.println("Course had been deleted, returning...");
    }

    private void showCourse() {
        System.out.println("Below you can filter through the courses and search for a specific course");

        boolean flag = true;

        do{
            System.out.println("""
                    Enter what you would like to filter on
                    1. ID
                    2. Name
                    3. Courses teacher
                    4. Date
                    0. Return
                   
                  """);

            String choice = scanner.nextLine();
            switch (choice){
                case "0":
                    flag = false;
                    break;
                case "1":
                    System.out.println("Enter the course ID");
                    long id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Courses found: ");
                    courseDao.getAll().forEach(System.out::println);

                case "2":
                    System.out.println("Enter the course name: ");
                    String name = scanner.nextLine();
                    System.out.println("Courses found: ");
                    courseDao.getByName(name).forEach(System.out::println);

                case "3":
                    System.out.println("Enter ID of the teacher");
                    int teacherID = Integer.parseInt(scanner.nextLine());
                    Teacher teacher = teacherDao.getById(teacherID);
                    System.out.println("Teachers found");
                    courseDao.getByTeacher(teacher).forEach(System.out::println);



            }

        }while(flag);
    }

    private void updateCourse() {
        System.out.println(courseDao.getAll());
        System.out.println("Enter ID of the course you want to update");
        int inputID = Integer.parseInt(scanner.nextLine());

        System.out.println("Updating:" + courseDao.getById(inputID));



    }

}
