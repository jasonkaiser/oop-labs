package org.example;


public class Logger {

    private static Logger instance;

    private Logger(){}

    public static synchronized Logger getInstance(){

        if(instance == null){
            instance = new Logger();
        }

        return instance;
    }

    public void log(String message){
        System.out.println("LOG | " + message);
    }
    public void logInfo(String message){
        System.out.println("LOG-INFO | " + message);
    }
    public void logWarning(String message){
        System.out.println("LOG-WARNING | " + message);
    }
    public void logError(String message){
        System.out.println("LOG-ERROR | " + message);
    }

}