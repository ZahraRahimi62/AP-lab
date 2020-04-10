package com.company;

/**
 * To examine the classes and the methods
 * @author Zahra Rahimi
 */
public class Main {

    public static void main(String[] args) {
        Circle circle1 = new Circle(19);
        Circle circle2 = new Circle(3);

        Rectangle rect1 = new Rectangle(1,4,1,4);
        Rectangle rect2 = new Rectangle(8,5,8,5);
        Rectangle rect3 = new Rectangle(6,6,6,6);
        Rectangle rect4 = new Rectangle(4,4,4,4);

        Triangle tri1 = new Triangle(2,2,2);
        Triangle tri2 = new Triangle(4,4,6);

        if(rect4.isSquare())
            System.out.println("rect4 is a square:)");

        Paint paint = new Paint();
        paint.addCircle(circle1);
        paint.addCircle(circle2);
        paint.addRectangle(rect1);
        paint.addRectangle(rect2);
        paint.addRectangle(rect3);
        paint.addTriangle(tri1);
        paint.addTriangle(tri2);
        paint.drawAll();
        paint.printAll();

    }
}
