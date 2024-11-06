package org.example;

import java.util.ArrayList;
import java.util.HashMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


     public static void main(String[] args) {


         Calculator calculator = new Calculator();
         ReverseOrder reverse = new ReverseOrder();

         ArrayList<Integer> ints = new ArrayList<>();
         ArrayList<String> strings = new ArrayList<>();

         ints.add(1);
         ints.add(2);
         ints.add(3);
         ints.add(4);
         ints.add(5);

         strings.add("Test");
         strings.add("Words");
         strings.add("Jason");

         calculator.sumOfEvenAndOddNumbers(ints);
         reverse.reverseList(strings);
         reverse.reverseList(ints);


        /* Dictionary Class

        Dictionary dictionary = new Dictionary();


        dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("cembalo", "harpsichord");


        ArrayList<String> translations = dictionary.translationList();
        for (String translation : translations) {
            System.out.println(translation);
        }

        /* HashMap Exercises

        HashMap<String, String> names = new HashMap<>();
        names.put("matti", "mage");
        names.put("mikael", "mixu");
        names.put("arto", "arppa");

        System.out.println(names.get("mikael"));

        PromissoryNote mattisNote = new PromissoryNote();
        mattisNote.setLoan("Arto", 51.5);
        mattisNote.setLoan("Mikael", 30.0);
        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
        System.out.println(mattisNote.howMuchIsTheDebt("Joel"));

        */



        // NightSky Class

        /* NightSky nightSky = new NightSky(8, 4);
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
        System.out.println("");
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint()); */

        /* Library / Book Class

        Library Library = new Library();


        Library.addBook(new Book("Cheese Problems Solved", "Woodhead Publishing", 2007));
        Library.addBook(new Book("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        Library.addBook(new Book("NHL Hockey", "Stanley Kupp", 1952));
        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));


        for (Book book: Library.searchByTitle("CHEESE")) {
            System.out.println(book);
        }


        System.out.println("---");
        for (Book book: Library.searchByPublisher("PENGUIN  ")) {
            System.out.println(book);
        }

         */


    }


}