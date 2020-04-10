package com.company;

import java.util.ArrayList;

// to test the program
// but it does not work properly but I prefer to send it...

public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Zahra", "Rahimi");
        Person person2 = new Person("Dara", "Rahmati");

        ArrayList<String> votingOp1 = new ArrayList<String>();
        ArrayList<String> votingOp2 = new ArrayList<String>();
        ArrayList<String> votingChoices1 = new ArrayList<String >();

        votingOp1.add("Red");
        votingOp1.add("Blue");

        votingOp2.add("Reaching to first grade in CE :)");
        votingOp2.add("Apply for the best university :)");

        VotingSystem votingSystem = new VotingSystem();
        votingSystem.createVoting("What is your favorite color? ", 0, votingOp1);
        votingSystem.createVoting("What is your goals? ", 1, votingOp2);

        votingChoices1.add("Red");

        votingSystem.vote(0, person1, votingChoices1);
        votingSystem.printVoting(0);

    }
}
