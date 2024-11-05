package org.example;

public class Book {

    /* Let us start with the class Book. The class has instance variables title for the book title, publisher
    for the name of the publisher, and year for the publishing year. The title
    and the publisher are of the type String and the publishing year is represented as an integer.
     Now implement the class Book. The class should have the constructor public Book(String title, String publisher, int year)
     and methods public String title(), public String publisher(), public int year() and public String toString().
     */


    private String title;
    private String publisher;
    private int year;

    // ------------------- [ CONSTRUCTORS ] ------------------------ //

    public Book(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }

    // ------------------- [ GETTERS AND SETTERS ] ------------------------ //

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // ------------------- [ METHODS ] ------------------------ //

    public String title(){

        return this.title;
    }

    public String publisher(){

        return this.publisher;
    }

    public int year(){

        return this.year;
    }

    public String toString(){

        return "Title: " + title() +
               "\nPublisher: " + publisher() +
               "\nYear: " + year() ;
    }
}
