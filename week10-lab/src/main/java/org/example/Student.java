package org.example;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String id;
    private List<Integer> grades = new ArrayList<>();

    public static void main(String[] args) {

    }

    public Student(String name, String id, List<Integer> grades) {
        this.name = name;
        this.id = id;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " - ID: " + getId() + "\nGrades: " + getGrades();
    }
}
