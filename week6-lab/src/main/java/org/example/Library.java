package org.example;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book > books;

    public Library(){
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void printBooks(){
        for(Book i : books){
            System.out.println(i + "\n");
        }
    }

    public ArrayList<Book> searchByTitle(String title){

        ArrayList<Book> found = new ArrayList<>();

        for(Book i : books){
            if(StringUtils.included(i.getTitle(),title)){
                found.add(i);
            }
        }
        return found;
    }

    public ArrayList<Book> searchByPublisher(String publisher){

        ArrayList<Book> found = new ArrayList<>();

        for(Book i : books){
            if(StringUtils.included(i.getPublisher(),publisher)){
                found.add(i);
            }
        }
        return found;
    }

    public ArrayList<Book> searchByYear(int year){

        ArrayList<Book> found = new ArrayList<>();

        for(Book i : books){
            if(i.getYear() == year){
                found.add(i);
            }
        }
        return found;
    }

}
