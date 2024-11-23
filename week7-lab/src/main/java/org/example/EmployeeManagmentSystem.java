package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class EmployeeManagmentSystem{

    public static void main(String[] args){

        EmployeeRecord employee1 = new EmployeeRecord("Alice", Role.JUNIOR, 45000, 2015);
        EmployeeRecord employee2 = new EmployeeRecord("Bob", Role.SENIOR, 75000, 2012);
        EmployeeRecord employee3 = new EmployeeRecord("Charlie", Role.TEAM_LEADER, 95000, 2020);
        EmployeeRecord employee4 = new EmployeeRecord("Diana", Role.JUNIOR, 50000, 2018);
        EmployeeRecord employee5 = new EmployeeRecord("Eve", Role.SENIOR, 70000, 2010);


        EmployeeManagment employeeManagement = new EmployeeManagment(new ArrayList<>());


        employeeManagement.addEmployeeRecord(employee1);
        employeeManagement.addEmployeeRecord(employee2);
        employeeManagement.addEmployeeRecord(employee3);
        employeeManagement.addEmployeeRecord(employee4);
        employeeManagement.addEmployeeRecord(employee5);


        System.out.println("\nEmployees with more than 5 years of service:");
        List<EmployeeRecord> filteredEmployees = employeeManagement.filterEmployees();
        for (EmployeeRecord employee : filteredEmployees) {
            System.out.println(employee);
        }


        System.out.println("\nCalculating average salary:");
        employeeManagement.calculateAverageSalary();


        System.out.println("\nEmployees with role SENIOR:");
        employeeManagement.getEmployeesByRole(Role.SENIOR);

    }


}

enum Role{

    JUNIOR,
    SENIOR,
    TEAM_LEADER

}

record EmployeeRecord(String name, Role position, double salary, int employmentYear) {

    public EmployeeRecord(String name, Role position, double salary, int employmentYear){

        if(salary < 0){
            throw new IllegalArgumentException("Salaray can't be lower than 0");
        }

        this.name = name;
        this.position = position;
        this.salary = salary;
        this.employmentYear = employmentYear;

    }

}

class EmployeeManagment{

    private List<EmployeeRecord> employeeRecordList;

    public EmployeeManagment(List<EmployeeRecord> employeeRecordList) {
        this.employeeRecordList = new ArrayList<>();
    }

    public void addEmployeeRecord(EmployeeRecord employee){

        employeeRecordList.add(employee);
        System.out.println("Employee Added.");

    }

    public List<EmployeeRecord> filterEmployees(){

        int CURRENT_YEAR = 2024;
        List<EmployeeRecord> temp_list = new ArrayList<>();

        for(EmployeeRecord employee : employeeRecordList){
            if(CURRENT_YEAR - employee.employmentYear() > 5){

                temp_list.add(employee);
            }
        }
        return temp_list;
    }

    public void calculateAverageSalary(){

        double sum = 0;

        for(EmployeeRecord employee : employeeRecordList){
            sum+= employee.salary();
        }

        double avgSalary = sum / employeeRecordList.size();
        System.out.println("Average salary is: " + avgSalary +"$");

    }

    public void getEmployeesByRole(Role role){

        for(EmployeeRecord employee : employeeRecordList){
            if(employee.position() == role){

                System.out.println(employee);
            }
        }
    }

}