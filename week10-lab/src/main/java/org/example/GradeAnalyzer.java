package org.example;

import java.util.ArrayList;
import java.util.List;


public class GradeAnalyzer {

    private List<Integer> grades = new ArrayList<>();

    public GradeAnalyzer(List<Integer> grades){

        this.grades = grades;
    }

    public double calculateAverage(){

        double sum = 0;
        int counter = 0;
        for(Integer grade : grades){
            sum+= grade;
            counter++;
        }

        return sum/counter;

    }

    public void printSummary(){
        System.out.println("Grades: " + grades);
        System.out.println("Average Grade: " + calculateAverage());
    }

    public static void main(String[] args) {


    }
}
