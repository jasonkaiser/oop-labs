package org.example;

import java.util.Random;

public class NightSky {


    private double density;
    private int width;
    private int height;
    private Random random = new Random();
    private int stars;

    // ------------------- [ CONSTRUCTORS ] ------------------------ //

    public NightSky(double density){
        this.density = density;
        this.width = 20;
        this.height = 10;
        this.stars = 0;
    }

    public NightSky(int width, int height){
        this.density = 0.1;
        this.width = width;
        this.height = height;
        this.stars = 0;
    }

    public NightSky(double density, int width, int height){
        this.density = density;
        this.width = width;
        this.height = height;
        this.stars = 0;

    }

    // ------------------- [ GETTERS AND SETTERS ] ------------------------ //

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
// ------------------- [ GENERAL METHODS ] ------------------------ //

    public void printLine() {

        for (int i = 0; i < this.width; i++) {
            if (random.nextDouble() <= this.density) {
                System.out.print("*");
                this.stars = this.stars + 1;
            } else {
                System.out.print(" ");
            }

        }
    }

    public void print(){

        for(int i = 0; i <= this.height; i++){
            printLine();
            System.out.println("");
        }
    }

    public int starsInLastPrint(){
        return this.stars;
    }

}
