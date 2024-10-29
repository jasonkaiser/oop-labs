package org.example;

public abstract class Vehicle {

    private String modelName;
    private int mileage;
    private int health;
    private int lifespan;

    // ------------------- [ CONSTRUCTORS ] ------------------------ //

    public Vehicle(String modelName){

        this.modelName = modelName;
        this.mileage = 0;
        this.health = 100;
        this.lifespan = 0;

    }

    public Vehicle(String modelName, int mileage, int health){

        this.modelName = modelName;
        this.mileage = mileage;
        this.health = health;
        this.lifespan = 0;

    }

    // ------------------- [ GETTERS / SETTERS ] ------------------------ //

    public String getModelName(){
        return this.modelName;
    }
    public void setModelName(String name){
        this.modelName = modelName;
    }
    public int getMileage(){
        return this.mileage;
    }
    public void setMileage(int mileage){
        this.mileage = mileage;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public int getHealth(){
        return health;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }
    // ------------------- [ ABSTRACT METHODS ] ------------------------ //

    abstract void service();
    abstract int expectedLifespan();

    // ------------------- [ GENERAL METHODS ] ------------------------ //

    public boolean needsMaintance(){

        if(this.health < 70){
            return true;
        }
        return false;
    }

    public void simulateYear(){

        setMileage(this.mileage + 500);
        setLifespan(this.lifespan - 500);
        setHealth(this.health - 2);

        if(this.mileage > (this.lifespan / 2 )){
            setHealth(this.health - 5);
        }


    }

    public String toString(){
        return "Name: " + this.modelName + "\nHealth: " + this.health + "\nMileage: " + this.mileage + "\nLifespan: " + this.lifespan;
    }

    public static void perfomMaintance( Vehicle vehicle){

        if(vehicle instanceof Car){
            ((Car) vehicle).repair();
        }

        if(vehicle instanceof Truck){
            ((Truck) vehicle).repair();
            ((Truck) vehicle).haul(500);
        }

        if(vehicle instanceof Motorcycle){
            ((Motorcycle) vehicle).race(40);
        }

    }



}
