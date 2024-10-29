package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {



        Vehicle car = new Car("AMG");
        Vehicle truck = new Truck("AMG");

        Vehicle.perfomMaintance(truck);



        /*  Vehicle[] vehicles = new Vehicle[] {
                new Car("amg"),
                new Truck("man"),
                new Motorcycle("suzuki")
        };


        for(Vehicle id : vehicles){
        id.simulateYear();
        id.service();

        if(id instanceof Car){
            Car car = (Car) id;
            car.drive(100);
        }

        if(id instanceof Truck){
            Truck truck = (Truck) id;
            truck.haul(6000);
        }

        if(id instanceof Motorcycle){
            Motorcycle motorcycle = (Motorcycle) id;
            motorcycle.race(30);
        }

        System.out.println();
    }

       */

    }
}