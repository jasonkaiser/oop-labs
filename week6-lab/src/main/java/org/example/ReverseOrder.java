package org.example;

import java.util.ArrayList;

public class ReverseOrder<T> {

    public T value;

    public ReverseOrder(){

    }

    public void reverseList(ArrayList<T> list){
        ArrayList<T> newList = new ArrayList<>();

        for(int i = list.size() - 1; i >= 0; i--){
            newList.add(list.get(i));
        }

        System.out.println(newList);
    }

}
