package org.example;

public class StringUtils {

    // ------------------- [ GENERAL METHODS ] ------------------------ //

    public static boolean included(String bookTitle, String inputTitle){
        if (bookTitle == null || inputTitle == null) {
            return false;
        }

        String trimmedBookTitle = bookTitle.trim().toUpperCase();
        String trimmedInputTitle = inputTitle.trim().toUpperCase();

        return trimmedBookTitle.contains(trimmedInputTitle);

    }

}
