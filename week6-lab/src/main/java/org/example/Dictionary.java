package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {

    HashMap<String, String> dictionary;

    public Dictionary(){
        this.dictionary = new HashMap<>();
    }

    public void add(String finnish, String english){
        dictionary.put(finnish, english);
    }

    public String translate(String finnish){
        return dictionary.getOrDefault(finnish, "The word " + finnish + " does not exist in the dictionary.");
    }

    public int amountOfWords(){
        return dictionary.size();
    }

    public ArrayList<String> translationList() {
        ArrayList<String> translationList = new ArrayList<>();

        for (String key : dictionary.keySet()) {
            String value = dictionary.get(key);
            translationList.add(key + " = " + value);
        }

        return translationList;
    }

}
