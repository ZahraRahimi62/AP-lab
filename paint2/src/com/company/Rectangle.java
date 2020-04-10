package com.company;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.PI;

public class Rectangle extends Polygon{

    /**
     * Create a Rectangle with the given sides
     * @param a side1
     * @param b side2
     * @param c side3
     * @param d side4
     */
    public Rectangle(int a, int b, int c, int d) {
        super(a, b, c, d);
        for(int i = 0; i < 4; i++){
            sides.get(i);
        }
    }


    /**
     * To diagnose that the rectangle is square or not
     * @return true if the rectangle is a square and false if the rectangle is not a square
     */
     public boolean isSquare(){
        if(sides.get(0) == sides.get(1) && sides.get(1) == sides.get(2) && sides.get(2) == sides.get(3) && sides.get(0) == sides.get(3))
            return true;
        return false;
    }


    /**
     * @return the perimeter of the rectangle
     */
    @Override
    public int calculatePerimeter(){
        int sum = 0;
        for(int i = 0; i < 4; i++){
            sum += sides.get(i);
        }
        return sum;
    }

    /**
     * @return the area of the rectangle
     */
    @Override
    public int calculateArea(){
        int area = 1;
        for(int i = 0; i < 4; i++){
            area *= sides.get(i);
        }
        return area;
    }

    /**
     * to draw the rectangle
     */
    @Override
    public void draw(){
        System.out.println("Rectangle , the area: " + calculateArea() + " , the perimeter: " + calculatePerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(sides, rectangle.sides);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sides);
    }

    @Override
    /**
     * @return the shape with its sides
     */
    public String toString(){
        String string = "";
        for(int i = 0; i < 4; i++){
            if(i == 3)
                string += "side" + (i+1) + ": " + sides.get(i);
            else
                string +="side" + (i+1) + ": " + sides.get(i) + ", ";
        }
        return "Rectangle, " + string;
    }

}
