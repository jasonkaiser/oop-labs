package org.example;

public class Car extends Vehicle implements Repairable {


    // ------------------- [ CONSTRUCTORS ] ------------------------ //

    public Car(String modelName) {
        super(modelName);
        this.setLifespan(150000);
    }

    public Car(String modelName, int mileage, int health) {
        super(modelName, mileage, health);
        this.setLifespan(150000);
    }

    // ------------------- [ OVERRIDDEN METHODS ] ------------------------ //

    @Override
    public void service() {
       System.out.println("Your Car is currently being serviced!");
       System.out.println("Changing oil.... Checking engine....");
       System.out.println(this);

    }

    @Override
    public int expectedLifespan() {
        return getLifespan();
    }

    @Override
    public void repair(){
        System.out.println("Engine turned on and changed oil for " + this.getModelName());
    }

    // ------------------- [ GENERAL METHODS ] ------------------------ //

    public void drive(int miles){

        System.out.println("Driving the car...");

        setHealth(getHealth() - 5);
        setMileage(getMileage() + miles);

        if( getHealth() < 30 ){
            setLifespan(getLifespan() - 10000);
        }

    }
}


