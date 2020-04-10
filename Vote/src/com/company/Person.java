package com.company;

public class Person {
    String firstName, lastName;

    /**
     * Create a person
     * @param firstName the first name of that person
     * @param lastName the last name of that person
     */
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Get the first name
     * @return the first name field
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get the last name
     * @return the last name field
     */
    public String getLastName() {
        return lastName;
    }

}
