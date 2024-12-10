package org.example;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class EmptyStudentListException extends RuntimeException {

    public EmptyStudentListException(String message){
        super(message);
    }

}

class InvalidStudentDataException extends Exception {

    public InvalidStudentDataException(String message){
        super(message);
    }
}
