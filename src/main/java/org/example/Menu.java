package org.example;

import org.example.commands.CourseCommands;
import org.example.commands.EducationCommands;
import org.example.commands.StudentCommands;
import org.example.commands.TeacherCommands;


import java.util.Scanner;

public class Menu {



    Scanner scanner = new Scanner(System.in);

    CourseCommands courseCommands = new CourseCommands();
    EducationCommands educationCommands = new EducationCommands();
    StudentCommands studentCommands = new StudentCommands();
    TeacherCommands teacherCommands = new TeacherCommands();


    private void printer(){
        System.out.println("""
    === School administration system ===
    === The current options are:
        [1]: Education command centre
        [2]: Course command centre
        [3]: Student command centre
        [4]: Teacher command centre
        [0]: Quit and exit the program  
    """);
    }

    public void firstOption(){
        String choice;
        boolean flag = true;
        while(flag){
            printer();
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> educationCommands.educationMenuOptions();
                case "2" -> courseCommands.courseMenuOptions();
                case "3" -> studentCommands.studentMenuOptions();
                case "4" -> teacherCommands.teacherMenuOptions();
                case "0" -> {
                    System.out.println("Exiting program...");
                    flag = false;
                }
            }
        }
    }

























}
