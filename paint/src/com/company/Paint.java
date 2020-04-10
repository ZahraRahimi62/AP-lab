package com.company;

import java.util.ArrayList;

public class Paint {
    ArrayList <Circle> circles = new ArrayList<>();
    ArrayList <Triangle> triangles = new ArrayList<>();
    ArrayList <Rectangle> rectangles = new ArrayList<>();

    /**
     * Add a circle to circles list
     * @param circle the circle to be added
     */
    public void addCircle(Circle circle){
        circles.add(circle);
    }

    /**
     * Add a triangle to triangles list
     * @param triangle the triangle to be added
     */
    public void addTriangle(Triangle triangle){
        triangles.add(triangle);
    }

    /**
     * Add a rectangle to rectangles list
     * @param rectangle the rectangle to be added
     */
    public void addRectangle(Rectangle rectangle){
        rectangles.add(rectangle);
    }
    /**
     * draw all shapes with their perimeter and area
     */
    public void drawAll(){
        for(int i = 0; i < circles.size(); i++){
            circles.get(i).draw();
        }
        for(int i = 0; i < triangles.size(); i++){
            triangles.get(i).draw();
        }
        for(int i = 0; i < rectangles.size(); i++){
            rectangles.get(i).draw();
        }
    }

    /**
     * print all shapes with their radius for circles and their sides for triangles and rectangles
     */
    public void printAll(){
        for(int i = 0; i < circles.size(); i++){
            System.out.println(circles.get(i).toString());
        }
        for(int i = 0; i < triangles.size(); i++){
            System.out.println(triangles.get(i).toString());
        }
        for(int i = 0; i < rectangles.size(); i++){
            System.out.println(rectangles.get(i).toString());
        }
    }
}
