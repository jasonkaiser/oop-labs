package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentSystem {

    List<Student> studentList;
    String fileName;

    public StudentSystem(String filename) throws FileNotFoundException {

        try {
            this.studentList = readStudents(filename);
            validateStudentData(this.studentList);
        } catch (InvalidStudentDataException e) {
            throw new RuntimeException("Invalid data in file: " + filename, e);
        }
    }

    public StudentSystem(List<Student> students) {

        try {
            validateStudentData(students);
        } catch (InvalidStudentDataException e) {
            System.err.println("Invalid student data: " + e.getMessage());
            this.studentList = new ArrayList<>();
        }
        this.studentList = students;

    }


    public List<Student> readFile() throws FileNotFoundException {


        BufferedReader reader = new BufferedReader(
                new FileReader(this.fileName)
        );

        List<String> rows = reader.lines().collect(Collectors.toList());

        if(rows.isEmpty()) throw new EmptyStudentListException("This Student List is empty!");

        List<Student> tmp_list = new ArrayList<>();

        for(String row : rows){
            String[] rowParts = row.split(",");
            tmp_list.add(
                    new Student(

                            rowParts[0].isEmpty() ? 0 : Integer.parseInt(rowParts[0]),
                            rowParts[1].trim().isEmpty() ? "UNKNOWN" : rowParts[1].trim(),
                            rowParts[2].trim().isEmpty() ? "UNKNOWN" : rowParts[2].trim(),
                            rowParts[3].trim().isEmpty() ? "UNKNOWN" : rowParts[3].trim(),
                            rowParts[4].isEmpty() ? 0.0 : parseSafeDouble(rowParts[4])

                    ));
        }

        return tmp_list;
    }



    public static List<Student> readStudents(String fileName) throws FileNotFoundException{

        BufferedReader reader = new BufferedReader(
                new FileReader(fileName)
        );

        List<String> rows = reader.lines().collect(Collectors.toList());
        if(rows.isEmpty()) throw new EmptyStudentListException("This file is empty");

        List<Student> tmp_list = new ArrayList<>();

        for(String row : rows){
            String[] rowParts = row.split(",");

                tmp_list.add(new Student(

                        rowParts[0] == "" ? 0 : Integer.parseInt(rowParts[0]),
                        rowParts[1].isEmpty() ? "UNKNOWN" : rowParts[1],
                        rowParts[2].isEmpty() ? "UNKNOWN" : rowParts[2],
                        rowParts[3].isEmpty() ? "UNKNOWN" : rowParts[3],
                        rowParts[4] == "" ? 0.0 : parseSafeDouble(rowParts[4])

                ));
        }

        return tmp_list;

    }

    private static double parseSafeDouble(String value) {
        try {
            return value.isEmpty() ? 0.0 : Double.parseDouble(value);
        } catch (NumberFormatException e) {
            System.err.println("Invalid double value: " + value);
            return 0.0;
        }
    }

    private void validateStudentData(List<Student> students) throws InvalidStudentDataException {
        for (Student student : students) {
            if (student.getGpa() < 6.0 || student.getGpa() > 10.0) {
                throw new InvalidStudentDataException("Read data has invalid rows.");
            }
        }
    }

    public Student getStudentByHighestGPA(){

        try {
            Student highestGPA = studentList.get(0);

            for (Student student : studentList) {
                if (student.getGpa() > highestGPA.getGpa()) {

                    highestGPA = student;

                }

            }

            return highestGPA;
        } catch (Exception e) {
            throw new EmptyStudentListException("This Student List is empty!");
        }
    }

    public Optional<Student> getStudentById(int id){

        for(Student student : studentList){

            if(student.getId() == id){
                return Optional.of(student);
            }
        }
            return Optional.ofNullable(null);
    };

    public int noOfStudents(){

        int counter = 0;

        for(Student student : studentList){
            counter++;
        }

        return counter;
    };

    public void printStudents(){

        if(studentList.isEmpty()){
            throw new EmptyStudentListException("This list is empty!");
        } else {

            for(Student student : studentList){
                System.out.println(student);
            }
        }

    }


}
