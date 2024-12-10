package org.example;

import java.util.Optional;

public class Student {

    private int id;
    private String name;
    private String university;
    private String department;
    private double gpa;

    public Student(int id, String name, String university, String department, double gpa){

        this.id = id;
        this.name = name;
        this.university = university;
        this.department = department;
        this.gpa = gpa;

    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public String getDepartment() {
        return department;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString(){
        return this.id + " | " + this.name + " | " + this.university + " | " + this.department + " | " + this.gpa + " | ";

    }
}
