package org.example;

public class PaymentSystem {

        public static void main(String[] args){

                PaymentFactory paymentFactory = new PaymentFactory();
                Payment test = paymentFactory.createPayment("CREDIT CARD");
                test.processPayment(23.0);
        }

}

interface Payment{
        void processPayment(double amount);
}

class CreditCardPayment implements  Payment{

        @Override
        public void processPayment(double amount) {
               System.out.println("CREDIT CARD | Thank you for your purchase of: " + amount);
        }
}

class PaypalPayment implements Payment{

        @Override
        public void processPayment(double amount) {
                System.out.println("PAYPAL | Thank you for your purchase of: " + amount);
        }
}

class PaymentFactory{
        public Payment createPayment(String type){
                if(type == null | type.isEmpty()){
                        return null;
                }
                switch (type.toUpperCase()){
                        case "PAYPAL":
                                return new PaypalPayment();
                        case "CREDIT CARD":
                                return new CreditCardPayment();
                        default: throw new IllegalArgumentException("Unknown provided Type.");
                }
        }
}


