package com.company;

import com.ghasemkiani.util.icu.PersianCalendar;

import java.util.Calendar;
import java.util.Objects;

public class Vote {
    Person person;
    PersianCalendar date;

    /**
     * @param p person
     * @param calendar the date of voting
     */
    public Vote(Person p, PersianCalendar calendar){
        person.lastName = p.lastName;
        person.firstName = p.firstName;
        date = calendar;
    }

    /**
     * Get the date
     * @return the date field
     */
    public PersianCalendar getDate() {
        return date;
    }

    /**
     * Get the person
     * @return the person field
     */
    public Person getPerson() {
        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vote voting = (Vote) o;
        return Objects.equals(person, voting.person) &&
                Objects.equals(date, voting.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, date);
    }

}
