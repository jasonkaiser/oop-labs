package org.example;

public class Motorcycle extends Vehicle{

    // ------------------- [ CONSTRUCTORS ] ------------------------ //

    public Motorcycle(String modelName){
        super(modelName);
        setLifespan(50000);
    }

    public Motorcycle(String modelName, int mileage, int health){
        super(modelName, mileage, health);
        setLifespan(50000);
    }

    // ------------------- [ OVERRIDDEN METHODS ] ------------------------ //

    @Override
    public void service(){
        System.out.println("Lubricating the chain...\nTunning the engine...");
        System.out.println(this);
    }

    @Override
    public int expectedLifespan(){
        return getLifespan();
    }

    // ------------------- [ GENERAL METHODS ] ------------------------ //

    public void race(int raceMiles){

        System.out.println("You are currently racing...");

        setMileage(getMileage() + raceMiles);
        setHealth(getHealth() - 15);

        if(getHealth() < 40){
            setLifespan(getLifespan() - 5000);
        }

    }

}
