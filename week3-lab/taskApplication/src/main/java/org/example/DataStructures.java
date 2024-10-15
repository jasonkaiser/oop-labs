package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStructures {

    private List<TaskItem> tasks = new ArrayList<>();

    public DataStructures(){

        tasks = Arrays.asList(
                new TaskItem(0, "null", Status.COMPLETED),
                new TaskItem(1, "This task needs to be done", Status.TO_DO),
                new TaskItem(2, "This task is finished", Status.COMPLETED),
                new TaskItem(3, "This task is work in progress", Status.IN_PROGRESS)
        );

    }

    public void displayTasks() {
        for (TaskItem task : tasks) {

            task.displayTask();
            System.out.println();
        }
    }

    public void getByStatus(Status status){

        for(TaskItem task : tasks) {

            if(task.task_status == status){
                task.displayTask();
                System.out.println();
            }
        }

    }

    public void getByID(){

        for(TaskItem task : tasks) {
            if(task.task_id >= 2){
                task.displayTask();
                System.out.println();
            }
        }
    }

    public void getAllTasksDescription(){

        for(TaskItem task : tasks){
            System.out.println("[ ID " + task.task_id + " ] " + task.task_description);
        }
    }

    public static void main(String[] args){

        DataStructures dataStructures = new DataStructures();
        dataStructures.getAllTasksDescription();



    }

}
