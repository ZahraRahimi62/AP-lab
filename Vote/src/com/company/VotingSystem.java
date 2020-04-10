package com.company;

import java.util.ArrayList;

public class VotingSystem {
    private ArrayList <Voting> votingList;

    public VotingSystem(){
        votingList =  new ArrayList<Voting>();
    }

    /**
     * Create new voting with the given question, type, votingList
     * @param question the question that is supposed to be polled
     * @param type the type of voting
     * @param choices the list of votings
     */
    public void createVoting(String question, int type, ArrayList<String> choices){
        if(type == 0){
            Voting voting = new Voting(type, question);
            votingList.add(voting);
            for(String string : choices)
                voting.createChoice(string);
        }
        else
            while(question != " "){
                Voting voting = new Voting(0, question);
                votingList.add(voting);
                for(String string : choices)
                    voting.createChoice(string);
            }

    }

    /**
     * print the voting choices
     */
    public void printVotingChoices(){
        for(Voting voting : votingList)
            System.out.println(voting.getQuestion());
    }

    /**
     * @param i
     */
    public void printVoting(int i){
        votingList.get(i).printVotes();
    }

    /**
     * @param count
     * @param person
     */
    public void vote(int count, Person person, ArrayList <String> choices){
        Voting voting = votingList.get(count);
        if( voting.getType() == 0 && choices.size() > 1){
            return;
        }
        else
            voting.vote(person, choices);
    }

    /**
     * @param count
     */
    public void printTheResults(int count){
        votingList.get(count).printVotes();
    }
}
