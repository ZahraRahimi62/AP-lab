package com.company;
import java.io.IOException;
public class Main {

    public static void main(String[] args) {
        ClockDisplay clock = new ClockDisplay();
        clock.setTime(23, 59, 59, 98);
        clock.print();
        for(int i=0; i<100; i++) {
            clock.timeTick();
            clock.print();
            // I wanted to clear the console every time but I could not
        }

    }

}
