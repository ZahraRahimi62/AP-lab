package com.company;

public class Main {
    public static void main(String[] args) {
        Student std1 = new Student("Ehsan", "Edalat", "9031066");
        Student std2 = new Student("Seyed", "Ahmadpanah", "9031806");
        Student std3 = new Student("Ahmad", "Asadi", "9031054");
        Student std4 = new Student("Zahra", "Rahimi", "9831026");

        std1.setGrade(16);
        std2.setGrade(18);
        std3.setGrade(20);
        std4.setGrade(19);

        Lab lab1 = new Lab(12 , "Friday");

        lab1.enrollStudent(std1);
        lab1.enrollStudent(std2);
        lab1.enrollStudent(std3);
        lab1.enrollStudent(std4);

        lab1.calculateAvg();
        lab1.print();
    }
}
