package org.example;

public class Main {

    public static void main(String[] args) {


        Logger logger = Logger.getInstance();


        logger.log("Application is starting.");
        logger.logInfo("Initialization successful.");
        logger.logWarning("Memory usage is high.");
        logger.logError("Unexpected error occurred.");
    }
}