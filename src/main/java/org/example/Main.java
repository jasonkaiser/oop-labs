package org.example;
import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        /* Task 1


        String password_key = "secret";

        while(true){

           System.out.println("Enter your password: ");
           String password_input = scanner.nextLine();

           if(password_input.equals(password_key)){
               System.out.println("Correct, the password is: " + password_input);
               break;
           }

        }
        */

        /* Task 2


        int result;
        int sum = 0 ;
        int i = 1;

        while(i <= 3){
            System.out.println(i +" - Input your number: ");
            int input = scanner.nextInt();
            sum+=input;
            i++;
        }

        System.out.println("Result is: " + sum);
        */

        /* Task 3


        int result;
        int sum = 0 ;
        int input = 1;

        while(input != 0){
            System.out.println(" - Input your number: ");
            input = scanner.nextInt();
            sum+=input;

        }

        System.out.println("Result is: " + sum);
        */

        /* Task 4

        System.out.println("Enter starting number: ");
        int startingNumber = scanner.nextInt();
        System.out.println("Enter ending number: ");
        int endingNumber = scanner.nextInt();

        if (startingNumber > endingNumber) {
            System.out.println(startingNumber);
        } else {
            while (startingNumber <= endingNumber) {

                System.out.println(startingNumber);
                startingNumber++;
            }
        }

        */

        /* Task 5

        int sum = 0;
        System.out.println("Input your number: ");
        int number = scanner.nextInt();

        for(int i = 0; i <= number; i++){
            sum+=(int)Math.pow(2, i);
        }
        System.out.println(sum);


        */

        /* Task 6

        printText(4);

        */

        /* Task 7

        System.out.println("Input your number: ");
        int number = scanner.nextInt();

        for(int i = 0; i < number; i++){
            for(int j = 0; j < i+1; j++){
                System.out.print("*");
            }
            System.out.println("");
        }

         */

        /* Task 8

        System.out.println("Input your number: ");
        int number = scanner.nextInt();

        for(int i = number; i > 0; i--) {
            for(int j = 0; j < number -1; j++){
                System.out.print("*");
            }
            System.out.println(" ");
        }

     */

        // Task 9

        for(int i = 1; i <= 5; i++){
            for (int j = 1; j < i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    public static void printText(int number){
        for(int i = 0; i < number; i++){
            System.out.println("In the beginning there were the swamp, the hoe and Java.");
        }
    }
}