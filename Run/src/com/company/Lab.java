package com.company;

public class Lab {
    // the lab’s capacity
    private int capacity =12;
    // the array of students
    private Student[] students = new Student[capacity];
    // the student’s average
    private double avg;
    // the student’s sum of student’s grades
    private int sum = 0;
    private String day;
    // the current size of lab
    private int currentSize = 0;

    /**
     * Create a new lab with a given capacity and day.
     * @param cap the capacity of lab
     * @param d the day
     */
    public Lab(int cap, String d) {
        capacity = cap;
        day = d;
    }
    /**
     * @param std the student that wants to be added
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = new Student(std.firstName, std.lastName, std.id );
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * get the array of students
     * @return students field
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * @param students set the students’id , name , grade
     */
    public void setStudents(Student[] students) {
        this.students = students ;
    }

    /**
     * get the average of students’grade
     * @return the avg field
     */
    public double getAvg() {
        return avg;
    }

    /**
     * calculate the sum of students
     */
    public void calculateAvg() {
        //i = new student(i.firstName, i.lastName, i.id, i.grade);
        for(int i=0 ; i<currentSize ; i++)
            sum = sum + students[i].getGrade();
        avg = (double)sum / currentSize;
    }

    /**
     * get the day of lab
     * @return the day field
     */
    public String getDay(){
        return day;
    }

    /**
     * @param day set the day of lab
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * get the capacity of lab
     * @return the capacity field
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity set the capacity of lab
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * print the lab’s students id, average, first name, last name and day
     */
    public void print() {
        for(int i=0; i<currentSize ; i++){
            students[i].print();
        }
        System.out.printf("The numbers of student in lab:%d " , currentSize );
        System.out.printf(", The average:%.2f " , avg );
        System.out.printf(", The day is: %s" , day);
    }
}
