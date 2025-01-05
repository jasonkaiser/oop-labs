package org.example;

public class State {
    public static void main(String[] args) {
        TrafficLightContext context = new TrafficLightContext();

        System.out.println("Initial State: Red");
        context.transitionToGreen();
        context.transitionToYellow();
        context.transitionToRed();
        context.transitionToYellow();
    }
}

interface TrafficLightState{

    public void transitionToRed(TrafficLightContext context);
    public void transitionToYellow(TrafficLightContext context);
    public void transitionToGreen(TrafficLightContext context);

}

class RedLightState implements TrafficLightState{

    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("It is already Red State");
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Transition to Yellow");
    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("We must wait for the Yellow State");
    }
}

class GreenLightState implements TrafficLightState{

    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Transition to Red");
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("We must wait for the Red State");

    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("It is already Green State");

    }
}

class YellowLightState implements TrafficLightState{


    @Override
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("We must wait for the Green State");
    }

    @Override
    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("It is already Yellow State");
    }

    @Override
    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Transition to Green");
    }
}

class TrafficLightContext{

    private TrafficLightState state;

    public TrafficLightContext(){
        this.state = new RedLightState();
    }

    public void setState(TrafficLightState state){
        this.state = state;
    }

    public void transitionToRed(){
        state.transitionToRed(this);
    }
    public void transitionToGreen(){
        state.transitionToGreen(this);
    }
    public void transitionToYellow(){
        state.transitionToYellow(this);
    }

}