package com.company;
import com.ghasemkiani.util.icu.PersianCalendar;

import java.util.*;

public class Voting {
    private int type;
    private String question;
    private ArrayList <Person> voters ;
    private Map <String, HashSet<Vote>> polls ;
    private ArrayList <String> choices;

    /**
     * Create a voting with given type and question
     * @param type the type of voting
     * @param question the question that is supposed to be polled
     */
    public Voting(int type, String question) {
        this.type = type;
        this.question = question;
        voters = new ArrayList<Person>();
        polls = new HashMap<String, HashSet<Vote>>();
        choices = new ArrayList<String>();
    }

    /**
     * Get the question
     * @return the question field
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question
     */
    public void createChoice(String question) {
        polls.put(question, new HashSet<Vote>());
        choices.add(question);
    }

    /**
     * @param person
     */
    public void vote(Person person, ArrayList<String> choices){
        int count = 0;
        for(int i=0; i<voters.size() ; i++){
            if(voters.get(i).equals(person))
                count++;
        }
        if(count == 0 ) {
            PersianCalendar calendar = new PersianCalendar();
            Vote vote = new Vote(person, calendar);
            voters.add(person);

            for (String string : choices) {
                if (choices.contains(string))
                    polls.get(string).add(vote);
            }
        }
        else
            return;
    }

    /**
     * get the type of voting
     * @return the type filed
     */

    public int getType() {
        return type;
    }

    /**
     * get the voters
     * @return the voters field
     */
    public ArrayList<Person> getVoters() {
        return voters;
    }

    /**
     * print the information of votes
     */
    public void printVotes(){
        Set<String> set = polls.keySet();
        for(String string : set){
            System.out.println(string + " " + polls.get(string));
        }
    }

}
