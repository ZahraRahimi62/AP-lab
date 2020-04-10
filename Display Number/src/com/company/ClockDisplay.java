package com.company;
/**
 *
 */
public class ClockDisplay {
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private NumberDisplay seconds;
    private NumberDisplay HundredOfSeconds;
    private String displayString;    // simulates the actual display

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        HundredOfSeconds = new NumberDisplay(100);
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the
     * parameters.
     */
    public ClockDisplay(int hour, int minute, int second, int hundredOfSecond)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        seconds = new NumberDisplay(60);
        HundredOfSeconds = new NumberDisplay(100);
        setTime(hour, minute, second, hundredOfSecond);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        HundredOfSeconds.increment();
        if(HundredOfSeconds.getValue() == 0){
            seconds.increment();
            if(seconds.getValue() == 0){  // it just rolled over!
                minutes.increment();
                if(minutes.getValue() == 0) {  // it just rolled over!
                    hours.increment();
                }
            }
        }
        alarm();
        updateDisplay();
    }
    public void alarm()
    {
        if(HundredOfSeconds.getValue() == 0 ){
            if(seconds.getValue() == 0 ){  // it just rolled over!
                if(minutes.getValue() == 0) {  // it just rolled over!
                    if(hours.getValue() == 0 || hours.getValue() == 6 || hours.getValue() == 12)
                        System.out.println("Wake Up!!!");
                }
            }
        }
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, int second, int HundredOfSecond)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        seconds.setValue(second);
        HundredOfSeconds.setValue(HundredOfSecond);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }

    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" +
                minutes.getDisplayValue() + ":" + seconds.getDisplayValue() + ":" + HundredOfSeconds.getDisplayValue();
    }
    public void print()
    {
        System.out.println(displayString);
    }
}
