package org.example;

import java.io.*;
import java.sql.Array;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Events {

    public static void main(String[] args) throws IOException {

        Events eventGenerator = new Events();
        //eventGenerator.generateEventsFile("eventRecords", 10);
        // eventGenerator.printEventsFromFile("eventRecords");
        ArrayList<String> eventsList = eventGenerator.readEventsFromFile("eventRecords");

        for(String event : eventsList){
            System.out.println(event);
        }

    }

    public void generateEventsFile(String fileName, int records) throws IOException {

        BufferedWriter file = new BufferedWriter(new FileWriter(fileName + ".txt"));

        for(int i = 0; i <= records; i++){
            Event event = new Event();
            String temp_event = event.toString();
            file.write(temp_event + "\n");
        }

        file.close();

    }

    public void printEventsFromFile(String fileName) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader(fileName + ".txt"));
        String line;

        while((line = file.readLine()) != null){
            System.out.println(line);
        }

        file.close();

    };

    public ArrayList<String> readEventsFromFile(String fileName) throws IOException{

        ArrayList<String> events = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));
        String line;

        while((line = reader.readLine()) != null){
            events.add(line);
        }

        reader.close();

        return events;
    }

}


class Event{

    private Instant timestamp;
    private String eventType;
    private int userId;
    private List<String> events = new ArrayList<>(Arrays.asList("Login", "Logout", "Purchase", "ViewPage", "Error"));

    public Event(){


        Random random = new Random();
        int randomEvent = random.nextInt(events.size());
        int randomUser = random.nextInt(1000);

        this.timestamp = Instant.now();
        this.eventType = events.get(randomEvent);
        this.userId = randomUser;

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String toString(){
        return this.timestamp + "  |  Event Type: " + this.eventType + "  |  User ID: " + this.userId;
    }

    public static void main(String[] args) {

    }

}


