package com.company;

/**
 * To examine the classes and the methods
 * @author Zahra Rahimi
 */
public class Main {

    public static void main(String[] args) {
        Paint paint = new Paint();
/*
        Shape circle1 = new Circle(19);
        Shape circle2 = new Circle(3);
        Shape rect1 = new Rectangle(1,4,1,4);
        Shape rect2 = new Rectangle(8,5,8,5);
        Shape rect3 = new Rectangle(6,6,6,6);
        Shape tri1 = new Triangle(2,2,2);
        Shape tri2 = new Triangle(4,4,6);

        paint.addShape(circle1);
        paint.addShape(rect1);
        paint.addShape(rect2);
        paint.addShape(rect3);
        paint.addShape(tri1);
        paint.addShape(tri2);

        paint.drawAll();
        paint.printAll();
        paint.describeEqualSides();
*/
        //Circle circle1 = new Shape(19);    //the IS A relation said that circle is a shape thus we can not do it. Correction is:
        Shape circle1 = new Circle(19);

        Shape circle2 = new Circle(3);

        //Rectangle rect1 = new Triangle(1,4,1); ///the IS A relation said that circle is a shape thus we can not do it. Correction is:
        Shape rect1 = new Triangle(1 , 4, 1);

        Polygon rect2 = new Rectangle(8,5,8,5);
        Rectangle rect3 = new Rectangle(2, 4, 5,6 );
        Polygon tri1 = new Triangle(2,2,2);
        Triangle tri2 = new Triangle(4,4,6);
        Shape tri3 = new Triangle(2,2,2);

        circle1 = circle2;
        rect2 = rect3;
        tri1 = (Polygon) tri3;       // cast to Polygon
        circle2 = tri3;
        tri3 = tri2;


    }
}
