package com.company;

import java.util.ArrayList;

public class Paint {
    private ArrayList<Shape> shapes = new ArrayList<Shape>();

    /**
     * Add a shape to shapes list
     * @param shape the shape to be added
     */
    public void addShape(Shape shape){
        shapes.add(shape);
    }

    /**
     * draw all shapes with their perimeter and area
     */
    public void drawAll(){
        for(int i = 0; i < shapes.size(); i++){
            shapes.get(i).draw();
        }
    }

    /**
     * print all shapes with their radius for circles and their sides for triangles and rectangles
     */
    public void printAll(){
        for(int i = 0; i < shapes.size(); i++){
            System.out.println(shapes.get(i).toString());
        }
    }

    /**
     * print all shapes with their features
     */
    // I did this exersize with out isEqual and isEquilateral methods and wrote the same method to implement it
    public void describeEqualSides(){
        System.out.println("Equal sides polygon:");
        for(int i = 0; i < shapes.size(); i++){
            if(shapes.get(i) instanceof Polygon && ((Polygon) shapes.get(i)).isEqualSide()){
                System.out.println(shapes.get(i).toString() + ", is equilateral");
            }
        }
    }
}
