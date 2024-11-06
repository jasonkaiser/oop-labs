package org.example;

import java.util.ArrayList;

public class Calculator <T extends Number> {

    public T value;

    public Calculator(){

    };

    public void sumOfEvenAndOddNumbers(ArrayList<T> list){

        int sumEven = 0;
        int sumOdd = 0;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).intValue() % 2 == 0){
                sumEven += list.get(i).intValue();
            } else {
                sumOdd += list.get(i).intValue();
            }

        }
        System.out.println(sumEven);
        System.out.println(sumOdd);
    }

}
