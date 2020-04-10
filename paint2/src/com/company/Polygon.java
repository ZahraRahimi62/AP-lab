package com.company;

import java.util.ArrayList;

public class Polygon extends Shape{

    protected ArrayList <Integer> sides = new ArrayList<>();

    /**
     * Create a polygon
     * @param array the array of size of angles
     */
    public Polygon(Integer...array){
        super();
        for(int i : array)
            sides.add(i);
    }

    /**
     * Get ArrayList of sides
     * @return the sides field
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * To diagnose that the shape has the same angles or not
     * @return true if the shape has the same angles and false if does not have the same angles
     */
    public boolean isEqualSide(){
        for(int i = 0; i < sides.size()-1 ; i++) {
            if(sides.get(i) != sides.get(i+1))
                return false;
        }
        return true;
    }

}
