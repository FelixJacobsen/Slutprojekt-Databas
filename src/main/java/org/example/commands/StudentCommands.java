package org.example.commands;


import org.example.def.course.CourseImpl;
import org.example.def.education.Education;
import org.example.def.education.EducationImpl;
import org.example.def.student.Student;
import org.example.def.student.StudentImpl;


import java.util.Scanner;

public class StudentCommands {
    CourseImpl courseDao = new CourseImpl();
    EducationImpl educationDao = new EducationImpl();
    StudentImpl studentDao = new StudentImpl();


    Scanner scanner = new Scanner(System.in);

    public void studentMenuOptions() {
        boolean flag = true;
        String choice;
        while(flag){
            studentMenuPrinter();
            choice = scanner.nextLine();
            switch (choice) {
                case "0" -> {
                    System.out.println("Exiting education menu");
                    flag = false;
                }
                case "1" -> addStudent();
                case "2" -> updateStudent();
                case "3" -> showStudent();
                case "4" -> studentDao.getAll().forEach(System.out::println);
                case "5" -> removeStudent();
            }
        }
    }

    private void showStudent() {
        System.out.println("Below you can filter through the courses and search for a specific student");

        boolean flag = true;

        do{
            System.out.println("""
                    Enter what you would like to filter on
                    1. ID
                    2. Name
                    3. Age
                    4. Education
                    0. Return
                   
                  """);

            String choice = scanner.nextLine();
            switch (choice) {
                case "0" -> flag = false;
                case "1" -> searchID();
                case "2" -> searchName();
                case "3" -> searchAge();
                case "4" -> searchEducation();
            }
        }while(flag);
    }

    private void searchEducation() {
        System.out.println("Enter education ID");
        int educationID = Integer.parseInt(scanner.nextLine());
        Education education = educationDao.getById(educationID);
        System.out.println("Educations found");
        studentDao.getByEducation(education).forEach(System.out::println);
    }

    private void searchAge() {
        System.out.println("Enter the age of the student");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Students found: ");
        studentDao.getByAge(age).forEach(System.out::println);
    }

    private void searchName() {
        System.out.println("Enter the student name: ");
        String name = scanner.nextLine();
        System.out.println("Students found: ");
        studentDao.getByName(name).forEach(System.out::println);
    }

    private void searchID() {
        System.out.println("Enter the student ID");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Student found: ");
        System.out.println(studentDao.getById(id));
    }

    private void removeStudent() {
        System.out.println("Enter ID of the course you want to remove");
        System.out.println("Current courses: " + studentDao.getAll());

        int removeId = Integer.parseInt(scanner.nextLine());


        Student student = studentDao.getById(removeId);
        studentDao.delete(student);
        System.out.println("Course had been deleted, returning...");

    }

    private void updateStudent() {
        System.out.println(studentDao.getAll());
        System.out.println("Enter ID of the course you want to update");
        int inputID = Integer.parseInt(scanner.nextLine());

        System.out.println("Updating:" + studentDao.getById(inputID));

    }

    private void addStudent() {
        boolean redo = true;

        do {
            System.out.println("Enter student name: ");
            String studentName = scanner.nextLine();

            System.out.println("Enter student age");
            int age = Integer.parseInt(scanner.nextLine());

            Student student = new Student(studentName, age);
            System.out.println("Add student to a program? [y/n]");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("y")) {
                System.out.println("Enter ID of the education you want to add the student to");
                educationDao.getAll().forEach(System.out::println);

                int userInputID = Integer.parseInt(scanner.nextLine());
                Education education = educationDao.getById(userInputID);
                student.setEducation(education);
                studentDao.update(student);
            }

            System.out.println("Add another student?[y/n]");
            String addAnother = scanner.nextLine();
            if(addAnother.equals("n"))
                redo = false;
        }while(redo);
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
