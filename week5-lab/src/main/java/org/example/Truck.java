package org.example;

public class Truck extends Vehicle implements Repairable{

    // ------------------- [ CONSTRUCTORS ] ------------------------ //

        public Truck(String modelName){
            super(modelName);
            this.setLifespan(300000);
        }

        public Truck(String modelName, int mileage, int health){
            super(modelName, mileage, health);
            this.setLifespan(300000);
        }

    // ------------------- [ OVERRIDDEN METHODS ] ------------------------ //

        @Override
        public void repair(){
            System.out.println("Engine overhauled and tires replaced for: " + getModelName());
        }

        @Override
        public void service() {

            System.out.println("Servicing the truck....");
            System.out.println(this);

        }

        @Override
        public int expectedLifespan(){
            return getLifespan();
        }

    // ------------------- [ GENERAL METHODS ] ------------------------ //

    public void haul(int loadWeight){

        System.out.println("Hauling the weight...");

            if(loadWeight > 5000){
                setHealth(getHealth() - 20);
            }

            if(getHealth() < 40){
                setLifespan(getLifespan() - 20000);
            }
    }

}

