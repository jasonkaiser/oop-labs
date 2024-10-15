package org.example;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private static String USERNAME = "root";
    private static String PASSWORD = "Alexander000";
    private static String HOST = "jdbc:mysql://localhost:3306/taskApp";

    public static Connection connection;

    public Database() {

        try{
            connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
            System.out.println("Connected to the taskApp database.");
        } catch ( SQLException e){
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
        return conn;
    }

    public static List<String> getAllTasks(){

        List<String> tasks = new ArrayList<>();

        String query = "SELECT * FROM tasks";

        try{

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()){

                tasks.add(
                        "[ ID " + resultSet.getString("id") +
                        " ] - Task Description: " + resultSet.getString("task_description") +
                        " - Status: " + resultSet.getString("task_status")
                );

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

            return tasks;
    }

    public static void updateTaskDesc(int id, String description){

        try{

            String query = "UPDATE tasks SET task_description = ? WHERE ID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, description);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Task ID:" + id +" updated!");
            } else {
                System.out.println("Error");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void getTaskByID( int id){

        try{

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tasks WHERE id = ?");
            ps.setInt(1, id);

            ResultSet resultSet = ps.executeQuery();

            while(resultSet.next()){
                System.out.println("[ ID " + resultSet.getString("id") +
                        " ] - Task Description: " + resultSet.getString("task_description") +
                        " - Status: " + resultSet.getString("task_status")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args){
       Database db_connection = new Database();


      /*List<String> all_tasks = getAllTasks();

      for(String task : all_tasks ){
          System.out.println(task);
      }*/

        updateTaskDesc(2,"Quiz iz finished");
        getTaskByID(2);


    };



}
