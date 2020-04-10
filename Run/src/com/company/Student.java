package com.company;

public class Student {
    public static void main(String [] args){
        System.out.println("hi");
    }
    // the student’s first name
    public String firstName;
    // the student’s last name
    public String lastName;
    // the student ID
    public String id;
    //the grade private
    int grade;
    /**
     * Create a new student with a given name and ID number.
     *
     * @param fName first name of student
     * @param lname last name of student
     * @param sID student ID
     */
    public Student(String fName, String lname, String sID) {
        firstName = fName;
        lastName = lname;
        id = sID;
        grade = 0;
    }

//    /**
//     * Create a new student with a given name and ID number.
//     * @param fName fName first name of student
//     * @param lname lname last name of student
//     * @param sID student ID
//     * @param grade student grade
//     */
//    public student(String fName, String lname, String sID, int grade) {
//        firstName = fName;
//        lastName = lname;
//        id = sID;
//        this.grade = grade;
//    }
    /**
     * get the first name of student
     * @return firstName field
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     * @param firstName set first name of a student
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * get the grade of students
     * @return the grade field
     */
    public int getGrade(){
        return grade;
    }

    /**
     * @param newGrade set the new grade of students
     */
    public void setGrade(int newGrade){
        grade = newGrade;
    }

    /**
     * get the id of students
     * @return  id field
     */
    public String getId(){
        return id;
    }

    /**
     * @param id1 set the id of students
     */
    public void setId(String id1){
        id = id1;
    }
    /**
     * Print the student’s last name and ID number to the
     output terminal.
     */
    public void print() {
        System.out.println(firstName + " " + lastName + ", student ID: " + id + ", grade: " + grade);
    }

}
