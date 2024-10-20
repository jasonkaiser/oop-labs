package org.example;

public class Shape {


    private String color;
    private FillType fillType;
    private double area;

    public static void main(String[] args){

        Circle test = new Circle("blue", FillType.FILLED, 20);
        test.calculateArea();
        test.displayInfo();

        Shape test2 = new Shape("red", FillType.NOT_FILLED);
        test2.displayInfo();

        Rectangle test3 = new Rectangle("pink", FillType.FILLED, 20,4);
        test3.displayInfo();

    }

    public Shape(String color, FillType fillType){

        this.color = color;
        this.fillType = fillType;
        this.area = 0;

    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public FillType getFillType(){
        return fillType;
    }

    public void setFillType(FillType fillType){
        this.fillType = fillType;
    }

    public void setArea(double area){
        this.area = area;
    }

    public double getArea(){
        return area;
    }

    public void displayInfo(){

        System.out.println("Color: " + color);
        System.out.println("Fill Type: " + fillType);
        System.out.println("Area: " + area);

    }

}

class Circle extends Shape{

    private double radius;

    public Circle(String color, FillType fillType, double radius) {

        super(color, fillType);
        this.radius = radius;



    }

    public void calculateArea(){
        setArea(3.14*Math.pow(radius, 2));
    }

    public double calculateCircumfrence(double pi,double radius){
           return 2*pi*radius;
    }

    public double calculateCircumfrence(double radius){
        return 2*Math.PI*radius;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Radius: " + radius);

    }

}

class Rectangle extends Shape{

    private int width;
    private int height;

    public Rectangle(String color, FillType fillType, int width, int height){

        super(color, fillType);
        this.width = width;
        this.height = height;

    }

    @Override
    public double getArea(){
        return width*height;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Height: " + height);
        System.out.println("Width: " + width);

    }

}

