package com.company;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.PI;

public class Rectangle {

    ArrayList<Integer> sides = new ArrayList<Integer>(4);

    /**
     * Create a Rectangle with the given sides
     * @param a side1
     * @param b side2
     * @param c side3
     * @param d side4
     */
    public Rectangle(int a, int b, int c, int d) {
        sides.add(a);
        sides.add(b);
        sides.add(c);
        sides.add(d);
    }

    /**
     * Get ArrayList of sides
     * @return the sides field
     */
    public ArrayList<Integer> getSides() {
        return sides;
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
    public Double calculatePerimeter(){
        Double sum = 0.0;
        for(int i = 0; i < 4; i++){
            sum += sides.get(i);
        }
        return sum;
    }

    /**
     * @return the area of the rectangle
     */
    public Double calculateArea(){
        Double area = 1.0;
        for(int i = 0; i < 4; i++){
            area *= sides.get(i);
        }
        return area;
    }

    /**
     * to draw the rectangle
     */
    public void draw(){
        System.out.println("Rectangle , the area: " + calculateArea() + " ,the perimeter: " + calculatePerimeter());
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

    /**
     * @return the shape with its sides
     */
    public String toString(){
        String string = "";
        for(int i = 0; i < 4; i++){
            string += sides.get(i);
        }
        return "Rectangle, " + string;    }
}
