package org.example.commands;

import org.example.def.course.Course;
import org.example.def.course.CourseImpl;
import org.example.def.education.Education;
import org.example.def.education.EducationImpl;
import org.example.def.student.Student;
import org.example.def.student.StudentImpl;
import org.example.def.teacher.TeacherImpl;

import java.util.Scanner;

public class EducationCommands {
    CourseImpl courseDao = new CourseImpl();
    EducationImpl educationDao = new EducationImpl();
    TeacherImpl teacherDao = new TeacherImpl();
    StudentImpl studentDao = new StudentImpl();
    Education education = new Education();

    Scanner scanner = new Scanner(System.in);


    public void educationMenuOptions() {
        boolean flag = true;
        String choice;
        while (flag) {
            educationMenuPrinter();
            choice = scanner.nextLine();
            switch (choice) {
                case "0" -> {
                    System.out.println("Exiting education menu");
                    flag = false;
                }
                case "1" -> addEduction();
                case "2" -> updateEducation();
                case "3" -> showInformation();
                case "4" -> showAllEducations();
                case "5" -> removeEducation();
            }
        }


    }

    private void removeEducation() {
        System.out.println("`\n All current educations");
        educationDao.getAll().forEach(System.out::println);

        int removeId = Integer.parseInt(scanner.nextLine());


        Education education = educationDao.getById(removeId);
        educationDao.delete(education);
        System.out.println("Course had been deleted, returning...");


    }

    private void showInformation() {
        System.out.println("Below you can filter through the courses and search for a specific education");

        boolean flag = true;

        do {
            System.out.println("""
                      Enter what you would like to filter on
                      1. ID
                      2. Name
                      3. Participants
                      4. Courses
                      0. Return
                     
                    """);

            String choice = scanner.nextLine();
            switch (choice) {
                case "0":
                    flag = false;
                    break;
                case "1":
                    System.out.println("Enter the Education ID");
                    long id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Educations found: ");
                    educationDao.getAll().forEach(System.out::println);

                case "2":
                    System.out.println("Enter the Education name: ");
                    String name = scanner.nextLine();
                    System.out.println("Courses found: ");
                    educationDao.getAll().forEach(System.out::println);

                case "3":
                    System.out.println("Current number of Participants = " + education.getParticipants());
                    System.out.println("Enter new amount of participants");
                    int newParticipants = Integer.parseInt(scanner.nextLine());
                    education.setParticipants(newParticipants);

                case "4":
                    System.out.println("Current courses");
                    education.getStudentList().forEach(System.out::println);

                    System.out.println("Enter course ID you want to modify");
                    int courseID = Integer.parseInt(scanner.nextLine());
                    Course course = courseDao.getById(courseID);

                    boolean flag2 = true;
                    while (flag2) {
                        System.out.println("""
                                [0] Return
                                [1] Add course
                                [2] Delete course 
                                """);
                        String choice2 = scanner.nextLine();
                        switch (choice2) {
                            case "0":
                                flag2 = false;
                                break;
                            case "1":
                                education.addCourse(course);
                                courseDao.update(course);
                                break;
                            case "2":


                        }
                    }


            }

        } while (flag);


    }

    private void showAllEducations() {
        System.out.println("=====        List of all current educations           =====");
        educationDao.getAll().forEach(System.out::println);
    }

    private void updateEducation() {
        System.out.println(educationDao.getAll());
        System.out.println("Enter ID of the education  you want to update");
        int inputID = Integer.parseInt(scanner.nextLine());

        System.out.println("Updating:" + educationDao.getById(inputID));

    }

    private void addEduction() {



            System.out.println("Enter education name: ");
            String educationName = scanner.nextLine();

            System.out.println("Enter the number of participants");
            int participants = Integer.parseInt(scanner.nextLine());


            Education education = new Education(educationName, participants);

            System.out.println("Would you like to add a course to the education");
            String addCourse = scanner.nextLine();
            if (addCourse.equalsIgnoreCase("y")) {
                System.out.println("Enter a course ID to add to the education");
                int courseID = Integer.parseInt(scanner.nextLine());
                Course course = courseDao.getById(courseID);

                education.addCourse(course);
                courseDao.update(course);

                System.out.println("Would you like to add another course? [y/n]");
                String addAnother = scanner.nextLine();

            }


            System.out.println("Do you want to add students to this education? [Y/N]");

            String addStudents = scanner.nextLine();
            if (addStudents.equalsIgnoreCase("Y")) {
                int studentID = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter a student ID to add");

                Student student = studentDao.getById(studentID);
                education.addStudent(student);
                studentDao.update(student);

                System.out.println("Would you like to add a new education?");
                String another = scanner.nextLine();

            }

            educationDao.insert(education);

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


}
