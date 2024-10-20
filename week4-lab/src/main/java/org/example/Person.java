package org.example;


import java.util.ArrayList;
import java.util.List;

public class Person {

    private String full_name;
    private String address;
    private String country;
    private int age;


   public Person(String full_name, String address, String country, int age){

       this.full_name = full_name;
       this.address = address;
       this.country = country;
       this.age = age;
   }


   public String getName(){
       return full_name;
   }

    public void setName(String name){
        this.full_name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }


    public String toString(){
       return "Name: " + full_name + " \nAddress: " + address + "\nAge:" + age + "\nCountry: " + country;
    }


    public static void printDepartment(List<Person> list){

       for(Person person : list){
           System.out.println(person);
       }
    }

    public static void main(String[] args) {

       List<Person> department = new ArrayList<Person>();

       // department.add( new Person("Jason Kaiser", "Spasovdanska 14", "Croatia", 24));
       //  department.add(new Teacher("Sara Kaiser", "Spasovdanska 21", "Bosnia", 23, 5000));
       // printDepartment(department);

        Student jason = new Student("Marcus Kaiser", "Spasovdanska 23", "Serbia", 11, 1);
        jason.addGrade(9);
        jason.addGrade(9);
        jason.addGrade(10);
        System.out.println(jason);



    }


}

class Student extends Person{


    private int credits;
    private int student_id;
    private List<Integer> grades;


    public Student(String full_name, String address, String country, int age, int student_id) {
        super(full_name, address, country, age);
        this.credits = 0;
        this.student_id = student_id;
        this.grades = new ArrayList<>();
    }

    public void study(){
        credits++;
    }

    public void setStudent_id(int student_id){
        this.student_id = student_id;
    }

    public int getStudent_id(){
        return student_id;
    }

    public void addGrade(int grade){
        grades.add(grade);
    }

    public String toString(){
        return super.toString() + "\nCredits: " + credits + "\nStudent ID: "+ student_id + "\nGrades: " + grades;
    }
}

class Teacher extends Person{

    private int salary;

    public Teacher(String full_name, String address, String country, int age, int salary){
            super(full_name, address, country, age);
            this.salary = salary;
    }

    public String toString(){
        return super.toString() + "\nSalary: " + salary;
    }
}