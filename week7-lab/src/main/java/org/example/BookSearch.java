package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




class Library {

    private String libraryName;
    private List<Book> books;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Optional<Book> findBookByISBN(String ISBN){
        for(Book book : books){
            if(book.getIsbn().equals(ISBN)){
                return Optional.of(book);
            }
        }

        return Optional.empty();
    }

}


class Book {

    private String title;
    private String isbn;
    private String author;
    private Status status;

    public Book(String title, String isbn, String author, Status status) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + isbn + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}

enum Status{
     AVAILABLE,
     CHECKED_OUT,
     RESERVERD
}

class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }
}

public class BookSearch {
    public static void main(String[] args) {
        Library library = new Library("Test");

        library.addBook(new Book("1984", "9780451524935", "Teste", Status.AVAILABLE));
        library.addBook(new Book("Brave New World", "9780060850524", "Test1", Status.CHECKED_OUT));
        library.addBook(new Book("Fahrenheit 451", "9781451673319", "Test", Status.AVAILABLE));

        Book defaultBook = new Book("Default Title", "0000000000000", "Default Author", Status.AVAILABLE);

        Book book1 = library.findBookByISBN("9780451524935").orElse(defaultBook);
        System.out.println("orElse Example: " + book1);

        Book book2 = library.findBookByISBN("000000000").orElseGet(() -> new Book("Test", "Test", "Test", Status.AVAILABLE));
        System.out.println("orElseGet Example: " + book2);

        String test = "232323";

        try {
            Book book3 = library.findBookByISBN(test)
                    .orElseThrow(() -> new BookNotFoundException("Book with ISBN " + test + " not found!"));
            System.out.println("orElseThrow Example: " + book3);
        } catch (BookNotFoundException e) {
            System.out.println("orElseThrow Example: " + e.getMessage());
        }
    }

}
