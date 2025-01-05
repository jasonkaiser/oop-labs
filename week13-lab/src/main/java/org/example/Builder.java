package org.example;

import java.util.List;
public class Builder {
    public static void main(String[] args) {


        CoffeeDirector director = new CoffeeDirector();
        Coffee coffee_order1 = director.constructCoffe(new LatteBuilder()
                .setSize(Size.LARGE)
        );

        System.out.println(coffee_order1);

    }

}
class Coffee {

    String type;
    Size size;
    String toppings;

    Coffee(CoffeeBuilder coffeeBuilder){

        this.type = coffeeBuilder.type;
        this.size = coffeeBuilder.size;
        this.toppings = coffeeBuilder.toppings;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public String toString(){
        return "Size: " + this.size + "\nType: " + this.type + "\nToppings: " + this.toppings;
    }

    public static abstract class CoffeeBuilder{
        String type;
        Size size;
        String toppings;

        public CoffeeBuilder setType(String type){
            this.type = type;
            return this;
        }

        public CoffeeBuilder setSize(Size size){
            this.size = size;
            return this;
        }

        public CoffeeBuilder setToppings(String toppings){
            this.toppings = toppings;
            return this;
        }

        public abstract  Coffee build();

    }

}



class EspressoBuilder extends Coffee.CoffeeBuilder{

    public EspressoBuilder(){

        this.type = "Espresso";
        this.toppings = "Extra Milk";
    }

    @Override
    public Coffee build(){
        return new Coffee(this);
    }

}

class LatteBuilder extends Coffee.CoffeeBuilder{

    public LatteBuilder(){

        this.type = "Latte";
        this.toppings = "Nothing";
    }

    @Override
    public Coffee build(){
        return new Coffee(this);
    }

}

class CappuccinoBuilder extends Coffee.CoffeeBuilder{

    public CappuccinoBuilder(){

        this.type = "Cappuccino";
    }

    @Override
    public Coffee build(){
        return new Coffee(this);
    }

}


class CoffeeDirector{



    public Coffee constructCoffe(Coffee.CoffeeBuilder coffeeBuilder){
        return coffeeBuilder.build();
    }

}


enum Size {

    SMALL,
    MEDIUM,
       LARGE
}