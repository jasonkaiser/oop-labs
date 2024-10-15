package org.example;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class TaskItem {

    int task_id;
    String task_description;
    Status task_status;

    public TaskItem(int task_id, String task_description, Status task_status){

        this.task_id = task_id;
        this.task_description = task_description;
        this.task_status = task_status;

        insertTaskIntoDB();

    }

    private void insertTaskIntoDB(){

        Database db_connection = new Database();

        try{

            String query = "INSERT INTO tasks VALUES (?,?,?)";
            Connection conn = db_connection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setInt(1, task_id);
            ps.setString(2, task_description);
            ps.setString(3, task_status.name());

            int update = ps.executeUpdate();

            if(update > 0){
                System.out.println("Task Item Added to the Database");
            } else {
                System.out.println("Error");
            }

            ps.close();
            conn.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {



    }

    public void displayTask(){
        System.out.println("Task ID: " + task_id);
        System.out.println("Task Description: " + task_description);
        System.out.println("Task Status: " + task_status);
    }
}

