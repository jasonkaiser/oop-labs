package org.example;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        // Task 1

        Scanner scanner = new Scanner(System.in);
        String password_key = "secret";

        while(true){

           System.out.println("Enter your password: ");
           String password_input = scanner.nextLine();

           if(password_input.equals(password_key)){
               System.out.println("Right, the password is: " + password_input);
               break;
           }

        }

    }
}