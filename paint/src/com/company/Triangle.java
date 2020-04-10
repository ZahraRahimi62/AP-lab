package com.company;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Math.PI;

public class Triangle {
    ArrayList<Integer> sides = new ArrayList<Integer>(3);

    /**
     * Create a triangle with the given sides
     * @param a side1
     * @param b side2
     * @param c side3
     */
    public Triangle(Integer a, Integer b, Integer c) {
        sides.add(a);
        sides.add(b);
        sides.add(c);
    }

    /**
     * Get ArrayList of sides
     * @return the sides field
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }
    /**
     * To diagnose that the triangle is equilateral or not
     * @return true if the triangle is equilateral and false if the triangle is not equilateral
     */
    public boolean isEquilateral(){
        if(sides.get(0) == sides.get(1) && sides.get(1) == sides.get(2) && sides.get(0) == sides.get(3))
            return true;
        return false;
    }


    /**
     * @return the perimeter of the triangle
     */
    public Double calculatePerimeter(){
        Double sum = 0.0;
        for(int i = 0; i < 3; i++){
            sum += sides.get(i);
        }
        return sum;
    }

    /**
     * @return the area of the triangle
     */
    public Double calculateArea(){
        Double area = 1.0;
        for(int i = 0; i < 3; i++){
            area *= sides.get(i);
        }
        return area;
    }

    /**
     * to draw the triangle
     */
    public void draw(){
        System.out.println("triangle , the area: " + calculateArea() + " ,the perimeter: " + calculatePerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(sides, triangle.sides);
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
        for(int i = 0; i < 3; i++){
            string += sides.get(i);
        }
        return "Triangle, " + string;
    }

}
