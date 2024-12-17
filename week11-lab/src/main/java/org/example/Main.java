package org.example;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.example.StudentSystem.readStudents;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException, InvalidStudentDataException {

       StudentSystem studentSystem = new StudentSystem("C:\\Users\\jason\\IdeaProjects\\oop-labs\\week11-lab\\students.csv");

       System.out.println("Number of Students: " + studentSystem.noOfStudents());

       Optional<Student> student = studentSystem.getStudentById(123);

        if(student.isPresent()){
            System.out.println(student.get());
        } else {
            System.out.println("Student does not exist.");
        }

        System.out.println(studentSystem.getStudentByHighestGPA());





    }
}

