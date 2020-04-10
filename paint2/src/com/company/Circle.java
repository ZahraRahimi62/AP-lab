package com.company;

import java.util.Objects;
import static java.lang.Math.*;


public class Circle extends Shape {
    int radius;

    /**
     * Create a circle with the given radius
     * @param radius the radius
     */
    public Circle(int radius) {
        super();
        this.radius = radius;
    }

    /**
     * Get the radius
     * @return the radius field
     */
    public int getRadius() {
        return radius;
    }

    /**
     * @return the perimeter of the circle
     */
    public int calculatePerimeter(){
        return (int) (2 * PI * radius);
    }

    /**
     * @return the area of the circle
     */
    public int calculateArea(){
        return (int) PI * radius * radius;
    }

    /**
     * to draw the circle
     */
    public void draw(){
        System.out.println("circle ,the area: " + calculateArea() + " ,the perimeter: " + calculatePerimeter());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    /**
     * @return the shape with its radius
     */
    @Override
    public String toString(){
        return "Circle " + radius;
    }
}
