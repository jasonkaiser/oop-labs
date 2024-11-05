package org.example;

import java.util.HashMap;

public class PromissoryNote {

        private HashMap<String, Double> debts;

         // ------------------- [ CONSTRUCTORS ] ------------------------ //

        public PromissoryNote() {

            this.debts = new HashMap<>();

        }

        // ------------------- [ GENERAL METHODS ] ------------------------ //

        public void setLoan(String person, Double loan){
            debts.put(person, loan);
        }

        public double howMuchIsTheDebt(String person){

            return debts.getOrDefault(person, 0.0);
        }
}
