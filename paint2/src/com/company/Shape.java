package com.company;

import java.util.ArrayList;

public class Shape {
    ArrayList<Integer> sides = new ArrayList<Integer>(3);

    /**
     * Create a shape
     */
    public Shape(Integer...array){
        for(int i : array)
            sides.add(i);
    }

    /**
     * @return the shape with its sides
     */
    public String toString(){
        String string = "";
        return string;
    }

    /**
     * @return the perimeter of the shape
     */
    public int calculatePerimeter(){
        return 1;
    }

    /**
     * @return the area of the shape
     */
    public int calculateArea(){
        return 1;
    }

    /**
     * to draw the shape
     */
    public void draw(){
        System.out.println("shape ,the area: " + calculateArea() + " ,the perimeter: " + calculatePerimeter());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @param obj
     * @return true if both shape were equal
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
